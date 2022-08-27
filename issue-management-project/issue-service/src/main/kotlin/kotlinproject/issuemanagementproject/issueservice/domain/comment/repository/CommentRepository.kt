package kotlinproject.issuemanagementproject.issueservice.domain.comment.repository

import kotlinproject.issuemanagementproject.issueservice.domain.comment.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {

    fun findByIdAndUserId(id: Long, userId: Long): Comment?

}