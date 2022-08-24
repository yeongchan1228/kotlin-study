package kotlinstudy.todoproject.todo.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import kotlinstudy.todoproject.todo.domain.Todo

data class TodoListResponse(
    val items: List<TodoResponse>,
) {

//    fun size() : Int = items.size
    val size: Int
        @JsonIgnore // 다른 곳에서 참조 시 .size 가 안 되도록 설정
        get() = items.size

    fun get(index: Int) = items[index]

    companion object {
        @JvmStatic
        fun of(todoList: List<Todo>) =
             TodoListResponse(todoList.map(TodoResponse::of))
    }
}