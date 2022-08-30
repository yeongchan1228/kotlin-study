package kotlinproject.issuemanagementproject.service

import kotlinproject.issuemanagementproject.domain.entity.User
import kotlinproject.issuemanagementproject.domain.repository.UserRepository
import kotlinproject.issuemanagementproject.exception.UserExistsException
import kotlinproject.issuemanagementproject.model.SignUpRequest
import kotlinproject.issuemanagementproject.utils.BCryptUtils
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

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
}