apply(plugin = "kotlin-jpa")

//apply(plugin = "kotlin-allopen")
//
//allOpen {
//    annotation("javax.persistence.Entity")
//    annotation("javax.persistence.Embeddable")
//    annotation("javax.persistence.MappedSuperclass")
//}

dependencies{
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
}