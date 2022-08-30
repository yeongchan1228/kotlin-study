import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
    id("org.springframework.boot") version "2.7.3" apply false
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"

    kotlin("kapt") version "1.6.21"
}

java.sourceCompatibility= JavaVersion.VERSION_17

allprojects{
    group= "kotlin-project"
    version= "0.0.1-SNAPSHOT"

    repositories{
        mavenCentral()
    }
}

subprojects{
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "kotlin-spring")
    apply(plugin = "io.spring.dependency-management")

    dependencies{
// JWT
        implementation("com.auth0:java-jwt:3.19.2")

        // Kotlin 로깅
        implementation("io.github.microutils:kotlin-logging:1.12.5") // kotlin 기반 logging

        // Kotlin
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // H2
        runtimeOnly("com.h2database:h2")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    dependencyManagement{
        imports{
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) // 멀티 모듈에서 제대로 된 의존성 가져올 수 있게 해줌
        }
    }

    tasks.withType<KotlinCompile>{
        kotlinOptions{
            freeCompilerArgs =listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test>{
        useJUnitPlatform()
    }
}