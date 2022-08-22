package advanced

class MyGenerics<out T>(private val message: T) {
    fun printMessage() = println(message)
}

class MyGenerics2<in T>(private val message: T) {
    fun printMessage() = println(message)
}

fun main() {
    val myGenerics = MyGenerics("test")
    myGenerics.printMessage()

    val mutableList = mutableListOf<String>()

    val starProjection: List<*> = listOf("test")

    // PECS(Producer - extends(JAVA), out(Kotlin), Consumer - super(JAVA), in(Kotlin))
    val pecs = MyGenerics("test")
    /// CharSequence(상위) > String(하위)
    val charGenerics: MyGenerics<CharSequence> = pecs
    val stringGenerics2: MyGenerics2<String> = MyGenerics2<CharSequence>("test")

}