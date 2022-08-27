package kotlinproject.issuemanagementproject.issueservice.domain.comment

import kotlinproject.issuemanagementproject.issueservice.domain.BaseEntity
import kotlinproject.issuemanagementproject.issueservice.domain.issue.Issue
import javax.persistence.*

@Entity
class Comment(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    val id: Long? = null,

    val userId: Long,

    val username: String,

    var content: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "issue_id")
    val issue: Issue
) : BaseEntity()