package kotlinproject.issuemanagementproject.controller

import kotlinproject.issuemanagementproject.model.MeResponse
import kotlinproject.issuemanagementproject.model.SignInRequest
import kotlinproject.issuemanagementproject.model.SignInResponse
import kotlinproject.issuemanagementproject.model.SignUpRequest
import kotlinproject.issuemanagementproject.model.annotation.AuthToken
import kotlinproject.issuemanagementproject.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/signup")
    suspend fun signUp(@RequestBody request: SignUpRequest) {
        userService.signUp(request)
    }

    @PostMapping("/login")
    suspend fun login(@RequestBody request: SignInRequest): SignInResponse {
        return userService.signIn(request)
    }

    @DeleteMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun logout(@AuthToken token: String) {
        userService.logout(token)
    }

    @GetMapping("/me")
    suspend fun get(
        @AuthToken token: String,
    ) : MeResponse =
        MeResponse(userService.getByToken(token))

    @GetMapping("/{userId}/username")
    suspend fun getUsername(@PathVariable("userId") userId: Long): Map<String, String> {
        return mapOf("reporter" to userService.get(userId).username)
    }
}