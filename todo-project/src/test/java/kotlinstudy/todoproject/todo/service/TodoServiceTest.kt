package kotlinstudy.todoproject.todo.service

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import kotlinstudy.todoproject.todo.domain.Todo
import kotlinstudy.todoproject.todo.domain.TodoRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
class TodoServiceTest{

    @MockkBean
    lateinit var repository: TodoRepository

    lateinit var service: TodoService

    val stub: Todo by lazy {
        Todo(
            id = 1,
            title = "test",
            description = "test !!",
            done = false,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }

    @BeforeEach
    fun setUp() {
        service = TodoService(repository)
    }

    @Test
    fun `한 개의 Todo 반환`() {
        every { repository.findByIdOrNull(any()) } returns stub

        val actual = service.findById(1)

        assertThat(actual).isNotNull
        assertThat(actual).isEqualTo(stub)
        verify(exactly = 1) { repository.findByIdOrNull(any()) }
    }

}