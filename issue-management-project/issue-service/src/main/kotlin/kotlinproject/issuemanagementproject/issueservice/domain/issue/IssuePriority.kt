package kotlinproject.issuemanagementproject.issueservice.domain.issue

enum class IssuePriority {
    LOW, MEDIUM, HIGH;

    companion object {
        operator fun invoke(priority: String) = valueOf(priority.uppercase())
    }
}
