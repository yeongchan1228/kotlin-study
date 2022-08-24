package kotlinstudy.todoproject.todo.api

import kotlinstudy.todoproject.todo.api.model.TodoListResponse
import kotlinstudy.todoproject.todo.api.model.TodoRequest
import kotlinstudy.todoproject.todo.api.model.TodoResponse
import kotlinstudy.todoproject.todo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoControllerKt(
    private val todoService: TodoService, // 사용할 때 의존성 자동 주입
) {

    @GetMapping
    fun getAll() =
        ok(TodoListResponse.of(todoService.findAll()))

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long) =
        ok(TodoResponse.of(todoService.findById(id)))

    @PostMapping
    fun create(@RequestBody request: TodoRequest) =
        ok(TodoResponse.of(todoService.create(request)))

    @PostMapping("{id}")
    fun update(
        @PathVariable("id") id: Long,
        @RequestBody request: TodoRequest,
    ) =
        ok(TodoResponse.of(todoService.update(id, request)))

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable("id") id: Long,
    ) : ResponseEntity<Unit> {
        todoService.delete(id)

        return noContent().build()
    }
}