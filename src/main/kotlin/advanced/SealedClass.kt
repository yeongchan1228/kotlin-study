package advanced

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackEndDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("백엔드 개발자입니다. ${language}를 사용합니다.")
    }
}

data class FrontEndDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("프론트엔드 개발자입니다. ${language}를 사용합니다.")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {
        is BackEndDeveloper -> pool[developer.name] = developer
        is FrontEndDeveloper -> pool[developer.name] = developer
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backEndDeveloper = BackEndDeveloper(name = "test1")
    DeveloperPool.add(backEndDeveloper)

    val frontEndDeveloper = FrontEndDeveloper(name = "test2")
    DeveloperPool.add(frontEndDeveloper)

    println(DeveloperPool.get("test1"))
    println(DeveloperPool.get("test2"))
}