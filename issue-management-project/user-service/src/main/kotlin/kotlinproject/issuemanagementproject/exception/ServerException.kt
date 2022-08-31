package kotlinproject.issuemanagementproject.exception

sealed class ServerException(
    val code: Int,
    override val message: String,
) : RuntimeException(message)


data class UserExistsException(
    override val message: String = "이미 존재하는 유저입니다.",
) : ServerException(409, message)

data class UserNotFoundException(
    override val message: String = "존재하지 않는 유저입니다.",
) : ServerException(code = 404, message = message)

data class PasswordNotMatchedException(
    override val message: String = "일치하지 않는 패스워드입니다.",
) : ServerException(code = 410, message = message)

data class InvalidJwtTokenException(
    override val message: String = "유효하지 않은 토큰입니다.",
) : ServerException(code = 450, message = message)