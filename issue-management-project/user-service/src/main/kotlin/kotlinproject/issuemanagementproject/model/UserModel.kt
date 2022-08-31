package kotlinproject.issuemanagementproject.model

import kotlinproject.issuemanagementproject.domain.entity.User
import java.time.LocalDateTime

data class SignUpRequest(
    val email: String,
    val password: String,
    val username: String,
)

data class SignInRequest(
    val email: String,
    val password: String,
)

data class SignInResponse(
    val email: String,
    val username: String,
    val token: String,
)

data class MeResponse(
    val id: Long,
    val profileUrl: String?,
    val username: String,
    val email: String,
    val createdDate: LocalDateTime?,
    val lastModifiedDate: LocalDateTime?,
) {
    companion object {
        operator fun invoke(user: User) =
            with(user) {
                MeResponse(
                    id = id!!,
                    profileUrl = if (profileUrl.isNullOrEmpty()) null else "http://localhost:9090/images/$profileUrl",
                    username = username,
                    email = email,
                    createdDate = createdDate,
                    lastModifiedDate = lastModifiedDate,
                )
            }
    }
}