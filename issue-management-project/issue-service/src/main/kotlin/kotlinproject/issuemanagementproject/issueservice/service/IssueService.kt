package kotlinproject.issuemanagementproject.issueservice.service

import kotlinproject.issuemanagementproject.issueservice.domain.issue.Issue
import kotlinproject.issuemanagementproject.issueservice.domain.issue.IssueStatus
import kotlinproject.issuemanagementproject.issueservice.domain.issue.repository.IssueRepository
import kotlinproject.issuemanagementproject.issueservice.model.IssueRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class IssueService(
    private val issueRepository: IssueRepository
) {

    @Transactional
    fun create(userId: Long, request: IssueRequest) : Issue {
        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )

        return issueRepository.save(issue)
    }

    fun getIssuesByStatus(status: IssueStatus) : List<Issue>? =
        issueRepository.findIssueByStatusOrderByCreatedDateDesc(status)


}