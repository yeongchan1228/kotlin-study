package kotlinproject.issuemanagementproject.issueservice.api

import kotlinproject.issuemanagementproject.issueservice.config.AuthUser
import kotlinproject.issuemanagementproject.issueservice.domain.issue.IssueStatus
import kotlinproject.issuemanagementproject.issueservice.model.IssueListResponse
import kotlinproject.issuemanagementproject.issueservice.model.IssueRequest
import kotlinproject.issuemanagementproject.issueservice.model.IssueResponse
import kotlinproject.issuemanagementproject.issueservice.model.IssueUpdateRequest
import kotlinproject.issuemanagementproject.issueservice.service.IssueService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
    private val issueService: IssueService,
) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request: IssueRequest,
    ) = IssueResponse(issueService.create(authUser.userId, request))


    @GetMapping
    fun getIssuesByStatus(
        authUser: AuthUser,
        @RequestParam(value = "status", required = false, defaultValue = "TODO") status: IssueStatus,
    ) = IssueListResponse(issueService.getIssuesByStatus(status))

    @GetMapping("/{issueId}")
    fun getIssueDetail(
        @PathVariable("issueId") issueId: Long,
    ) = IssueResponse(issueService.getIssueByIssueId(issueId))

    @PutMapping("/{issueId}")
    fun updateIssue(
        authUser: AuthUser,
        @PathVariable("issueId") issueId: Long,
        @RequestBody updateRequest: IssueUpdateRequest,
    ) = IssueResponse(issueService.updateIssue(authUser.userId, issueId, updateRequest))

    @DeleteMapping("/{issueId}")
    fun deleteIssue(
        @PathVariable("issueId") issueId: Long,
    ) {
        issueService.deleteIssue(issueId)
    }
}