package kotlinproject.issuemanagementproject.issueservice.model

import com.fasterxml.jackson.annotation.JsonFormat
import kotlinproject.issuemanagementproject.issueservice.domain.issue.Issue
import kotlinproject.issuemanagementproject.issueservice.domain.issue.IssuePriority
import kotlinproject.issuemanagementproject.issueservice.domain.issue.IssueStatus
import kotlinproject.issuemanagementproject.issueservice.domain.issue.IssueType
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
)

data class IssueResponse(
    val id: Long,
    val summary: String,
    val description: String,
    val type: IssueType,
    val userId: Long,
    val priority: IssuePriority,
    val status: IssueStatus,

    @JsonFormat(pattern = "yyyy-MM-dd:HH:mm:ss")
    val createdDate: LocalDateTime?,

    @JsonFormat(pattern = "yyyy-MM-dd:HH:mm:ss")
    val lastModifiedDate: LocalDateTime?,
) {
    companion object {
        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse (
                    id = id!!,
                    summary = summary,
                    description = description,
                    type = type,
                    userId = userId,
                    priority = priority,
                    status = status,
                    createdDate = createdDate,
                    lastModifiedDate = lastModifiedDate,
                )
            }
    }
}

data class IssueListResponse(
    val size: Int? = 0,
    val issueResponses: List<IssueResponse>? = null,
) {
    companion object {
        operator fun invoke(issues: List<Issue>?) =
            IssueListResponse(
                size = issues?.size,
                issueResponses = issues?.map { IssueResponse(it) }
            )
    }
}

