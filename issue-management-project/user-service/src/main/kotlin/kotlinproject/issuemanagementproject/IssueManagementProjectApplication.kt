package kotlinproject.issuemanagementproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class IssueManagementProjectApplication

fun main(args: Array<String>) {
    runApplication<IssueManagementProjectApplication>(*args)
}
