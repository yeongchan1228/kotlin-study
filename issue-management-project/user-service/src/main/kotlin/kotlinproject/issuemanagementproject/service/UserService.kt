package kotlinproject.issuemanagementproject.service

import kotlinproject.issuemanagementproject.config.JWTProperties
import kotlinproject.issuemanagementproject.domain.entity.User
import kotlinproject.issuemanagementproject.domain.repository.UserRepository
import kotlinproject.issuemanagementproject.exception.InvalidJwtTokenException
import kotlinproject.issuemanagementproject.exception.PasswordNotMatchedException
import kotlinproject.issuemanagementproject.exception.UserExistsException
import kotlinproject.issuemanagementproject.exception.UserNotFoundException
import kotlinproject.issuemanagementproject.model.SignInRequest
import kotlinproject.issuemanagementproject.model.SignInResponse
import kotlinproject.issuemanagementproject.model.SignUpRequest
import kotlinproject.issuemanagementproject.utils.BCryptUtils
import kotlinproject.issuemanagementproject.utils.CoroutineCacheManager
import kotlinproject.issuemanagementproject.utils.JwtClaim
import kotlinproject.issuemanagementproject.utils.JwtUtils
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
) {

    companion object {
        private val CACHE_TTL = Duration.ofMinutes(1)
    }

    suspend fun signUp(signUpRequest: SignUpRequest) {
        with(signUpRequest) {
            userRepository.findByEmail(email)?.let {
                throw UserExistsException()
            }

            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username,
            )

            userRepository.save(user)
        }
    }

    suspend fun signIn(request: SignInRequest): SignInResponse {
        return with(userRepository.findByEmail(email = request.email) ?: throw UserNotFoundException()) {
            val verified = BCryptUtils.verify(request.password, password)
            if (!verified) {
                throw PasswordNotMatchedException()
            }

            val jwtClaim = JwtClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username,
            )

            val token = JwtUtils.createToken(
                jwtClaim,
                jwtProperties
            )

            cacheManager.awaitPut(key = token, this, CACHE_TTL)
            SignInResponse(
                email = email,
                username = username,
                token = token
            )
        }
    }

    suspend fun logout(token: String) {
        cacheManager.awaitEvict(token)
    }

    suspend fun getByToken(token: String): User {
        val cachedUser = cacheManager.awaitGetOrPut(key = token, ttl = CACHE_TTL) {
            val decodedJWT = JwtUtils.decode(token, jwtProperties.secret, jwtProperties.issuer)

            val userId = decodedJWT.claims["userId"]?.asLong() ?: throw InvalidJwtTokenException()
            get(userId)
        }

        return cachedUser
    }

    suspend fun get(userId: Long): User {
        return userRepository.findById(userId) ?: throw UserNotFoundException()
    }
}