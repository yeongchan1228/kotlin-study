package kotlinstudy.todoproject.todo.api.model;

import kotlinstudy.todoproject.todo.domain.Todo;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TodoListResponse {

    private final List<TodoResponse> items;

    private TodoListResponse(List<TodoResponse> items) {
        this.items = items;
    }

    public int size() {
        return items.size();
    }

    public TodoResponse get(int index) {
        return items.get(index);
    }

    public static TodoListResponse of(List<Todo> todoList) {
        List<TodoResponse> todoListResponse = todoList.stream()
            .map(TodoResponse::of)
            .collect(Collectors.toList());

        return new TodoListResponse(todoListResponse);
    }

}
