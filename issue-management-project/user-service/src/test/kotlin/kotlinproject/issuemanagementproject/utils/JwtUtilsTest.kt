package kotlinproject.issuemanagementproject.utils

import kotlinproject.issuemanagementproject.config.JWTProperties
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class JwtUtilsTest {

    private val logger = KotlinLogging.logger{}

    companion object {
        val properties = JWTProperties(
            issuer = "yc",
            subject = "auth",
            expiresTime = 3600,
            secret = "test"
        )

        val jwtClaim = JwtClaim(
            userId = 1,
            email = "dev@naver.com",
            profileUrl = "profile.png",
            username = "test"
        )
    }

    @Test
    fun createTokenTest() {
        val token = createJwt()

        assertNotNull(token)

        logger.info { token }
    }

    @Test
    fun decodeToken() {
        val token = createJwt()

        val decodedJWT = JwtUtils.decode(token, secret = properties.secret, issuer = properties.issuer)

        with(decodedJWT) {
            logger.info { "claims : $claims" }

            val userId = claims["userId"]!!.asLong()

            assertEquals(userId, 1)
        }
    }

    private fun createJwt(): String {
        return JwtUtils.createToken(jwtClaim, properties)
    }
}