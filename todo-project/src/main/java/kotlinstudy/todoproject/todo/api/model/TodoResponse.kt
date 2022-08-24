package kotlinstudy.todoproject.todo.api.model

import kotlinstudy.todoproject.todo.domain.Todo
import java.time.LocalDateTime

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String,
    val done: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
) {
    companion object {
        @JvmStatic
        fun of(todo: Todo?) : TodoResponse {
            checkNotNull(todo) {"Todo is null"}
            checkNotNull(todo.id) {"Todo id is null"}

            return TodoResponse(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                done = todo.done,
                createdAt = todo.createdAt,
                updatedAt = todo.updatedAt
            )
        }
    }
}
