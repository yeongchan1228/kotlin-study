package kotlinproject.issuemanagementproject.issueservice.api

import kotlinproject.issuemanagementproject.issueservice.config.AuthUser
import kotlinproject.issuemanagementproject.issueservice.model.CommentRequest
import kotlinproject.issuemanagementproject.issueservice.model.CommentResponse
import kotlinproject.issuemanagementproject.issueservice.model.toResponse
import kotlinproject.issuemanagementproject.issueservice.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/comments")
class CommentController(
    private val commentService: CommentService,
) {
    @PostMapping("/{issueId}")
    fun createComment(
        authUser: AuthUser,
        @RequestBody request: CommentRequest,
        @PathVariable("issueId") issueId: Long,
    ) = commentService.createComment(
        issueId = issueId,
        userId = authUser.userId,
        username = authUser.username,
        request = request,
    ).toResponse()

    @GetMapping("/{issueId}/{commentId}")
    fun getComment(
        authUser: AuthUser,
        @PathVariable("issueId") issueId: Long,
        @PathVariable("commentId") commentId: Long,
    ) : CommentResponse {
        println("111111")
        val comment = commentService.getComment(commentId)
        println("222222")
        println(comment.issue.status)

        return CommentResponse(comment.id!!, issueId, authUser.userId, comment.content, authUser.username)
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        authUser: AuthUser,
        @PathVariable("commentId") commentId: Long,
        @RequestBody request: CommentRequest,
    ) = commentService.updateComment(commentId, authUser.userId, request).toResponse()

    @DeleteMapping("{commentId}")
    fun deleteComment(
        authUser: AuthUser,
        @PathVariable("commentId") commentId: Long,
    ) {
        commentService.deleteComment(commentId, authUser.userId)
    }
}