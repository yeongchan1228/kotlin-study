package kotlinproject.issuemanagementproject.issueservice.model

import kotlinproject.issuemanagementproject.issueservice.domain.comment.Comment

data class CommentRequest(
    val content: String,
)

data class CommentResponse(
    val id: Long,
    val issueId: Long,
    val userId: Long,
    val content: String,
    val username: String? = null,
)

fun Comment.toResponse() = CommentResponse(
    id = id!!,
    issueId = issue.id!!,
    userId = userId,
    content = content,
    username = username
)