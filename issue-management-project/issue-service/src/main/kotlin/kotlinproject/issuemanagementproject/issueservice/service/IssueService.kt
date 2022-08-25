package kotlinproject.issuemanagementproject.issueservice.service

import kotlinproject.issuemanagementproject.issueservice.domain.issue.Issue
import kotlinproject.issuemanagementproject.issueservice.domain.issue.IssueStatus
import kotlinproject.issuemanagementproject.issueservice.domain.issue.repository.IssueRepository
import kotlinproject.issuemanagementproject.issueservice.exception.NotFoundException
import kotlinproject.issuemanagementproject.issueservice.model.IssueRequest
import kotlinproject.issuemanagementproject.issueservice.model.IssueUpdateRequest
import org.springframework.data.repository.findByIdOrNull
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

    fun getIssueByIssueId(issueId: Long): Issue =
        issueRepository.findByIdOrNull(issueId) ?: throw NotFoundException("해당 이슈를 찾을 수 없습니다.");

    @Transactional
    fun updateIssue(userId: Long, issueId: Long, updateRequest: IssueUpdateRequest): Issue {
        val findIssue = getIssueByIssueId(issueId)

        findIssue.update(request = updateRequest, userId = userId)

        return issueRepository.save(findIssue)
    }

    @Transactional
    fun deleteIssue(issueId: Long) {
        issueRepository.deleteById(issueId)
    }

}