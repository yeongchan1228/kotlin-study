package kotlinproject.issuemanagementproject.issueservice.api

import kotlinproject.issuemanagementproject.issueservice.config.AuthUser
import kotlinproject.issuemanagementproject.issueservice.model.IssueRequest
import kotlinproject.issuemanagementproject.issueservice.model.IssueResponse
import kotlinproject.issuemanagementproject.issueservice.service.IssueService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}