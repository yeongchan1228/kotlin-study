package kotlinproject.issuemanagementproject.issueservice.service

import kotlinproject.issuemanagementproject.issueservice.domain.comment.Comment
import kotlinproject.issuemanagementproject.issueservice.domain.comment.repository.CommentRepository
import kotlinproject.issuemanagementproject.issueservice.exception.NotFoundException
import kotlinproject.issuemanagementproject.issueservice.model.CommentRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CommentService(
    private val commentRepository: CommentRepository,
    private val issueService: IssueService,
) {

    @Transactional
    fun createComment(issueId: Long, userId: Long, username: String, request: CommentRequest) : Comment {
        val findIssue = issueService.getIssueByIssueId(issueId)

        val comment = Comment(
            userId = userId,
            issue = findIssue,
            username = username,
            content = request.content,
        )

        findIssue.comments.add(comment)
        return commentRepository.save(comment)
    }

    fun getComment(commentId: Long) = commentRepository.findByIdOrNull(commentId) ?: throw NotFoundException("comment를 찾을 수 없습니다.")

    @Transactional
    fun updateComment(commentId: Long, userId: Long, request: CommentRequest): Comment =
        commentRepository.findByIdAndUserId(commentId, userId)?.run {
            content = request.content
            commentRepository.save(this)
        } ?: throw NotFoundException("댓글을 찾을 수 없습니다.")

    @Transactional
    fun deleteComment(commentId: Long, userId: Long) {
        val comment =
            commentRepository.findByIdAndUserId(commentId, userId) ?: throw NotFoundException("댓글을 찾을 수 없습니다.")

        commentRepository.delete(comment)
    }
}