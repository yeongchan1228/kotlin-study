package kotlinproject.issuemanagementproject.issueservice.domain.issue

import kotlinproject.issuemanagementproject.issueservice.domain.BaseEntity
import javax.persistence.*

@Entity
class Issue(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var userId: Long,

    var summary: String,

    var description: String,

    @Enumerated(EnumType.STRING)
    var type: IssueType,

    @Enumerated(EnumType.STRING)
    var priority: IssuePriority,

    @Enumerated(EnumType.STRING)
    var status: IssueStatus,

    ) : BaseEntity()