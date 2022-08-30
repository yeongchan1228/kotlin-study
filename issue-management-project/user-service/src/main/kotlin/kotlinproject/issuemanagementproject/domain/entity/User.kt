package kotlinproject.issuemanagementproject.domain.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "users")
data class User(
    @Id
    val id: Long? = null,

    @Column
    val email: String,

    @Column
    val username: String,

    @Column
    val password: String,

    @Column
    val profileUrl: String? = null,

    @Column
    @CreatedDate
    val createdDate: LocalDateTime? = null,

    @Column
    @LastModifiedDate
    val lastModifiedDate: LocalDateTime? = null,
)