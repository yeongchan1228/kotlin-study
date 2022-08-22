package advanced

class HelloBot {
    private val greeting: String by lazy {
        println("초기화 실행")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "test"

class LateInit {
    lateinit var text: String

    val textInitialized: Boolean get() = this::text.isInitialized

    fun printText() {
        if (this::text.isInitialized) {
            println(text)
        }
        text = "text"
        println(text)
    }
}

fun main() {
    val helloBot = HelloBot()

    for (i in 0 until 5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }

    val lateInit = LateInit()
    lateInit.printText()
    println(lateInit.textInitialized)
}