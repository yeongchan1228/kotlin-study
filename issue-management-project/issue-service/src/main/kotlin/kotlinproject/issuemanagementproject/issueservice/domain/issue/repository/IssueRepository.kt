package kotlinproject.issuemanagementproject.issueservice.domain.issue.repository

import kotlinproject.issuemanagementproject.issueservice.domain.issue.Issue
import kotlinproject.issuemanagementproject.issueservice.domain.issue.IssueStatus
import org.springframework.data.jpa.repository.JpaRepository

interface IssueRepository : JpaRepository<Issue, Long> {

    fun findIssueByStatusOrderByCreatedDateDesc(status: IssueStatus) : List<Issue>?

}