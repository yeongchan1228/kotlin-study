package kotlinproject.issuemanagementproject.issueservice.domain.issue

import kotlinproject.issuemanagementproject.issueservice.domain.BaseEntity
import kotlinproject.issuemanagementproject.issueservice.domain.comment.Comment
import kotlinproject.issuemanagementproject.issueservice.model.IssueUpdateRequest
import javax.persistence.*

@Entity
class Issue(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    val id: Long? = null,

    var userId: Long,

    var summary: String,

    var description: String,

    @OneToMany(mappedBy = "issue", fetch = FetchType.EAGER)
    val comments: MutableList<Comment> = mutableListOf(),

    @Enumerated(EnumType.STRING)
    var type: IssueType,

    @Enumerated(EnumType.STRING)
    var priority: IssuePriority,

    @Enumerated(EnumType.STRING)
    var status: IssueStatus,

    ) : BaseEntity() {
    fun update(userId: Long, request: IssueUpdateRequest) {
        this.summary = request.summary ?: this.summary
        this.description = request.description ?: this.description
        this.type = request.type ?: this.type
        this.priority = request.priority ?: this.priority
        this.status = request.status ?: this.status
        this.userId = userId
    }
}