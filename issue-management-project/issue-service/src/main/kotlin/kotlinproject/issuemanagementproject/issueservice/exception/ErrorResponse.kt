package kotlinproject.issuemanagementproject.issueservice.exception

data class ErrorResponse(
    val code: Int,
    val message: String,
)