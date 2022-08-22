package advanced

fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this
}

class MyExample {
    fun printMessage() = println("클래스 출력")
    fun printMessage2() = println("클래스 출력")
}

fun MyExample.printMessage() = println("확장 함수 출력")

fun MyExample.printMessage2(message: String) = println(message)

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("null!!")
    else println("notNull!!")
}

fun main() {
    val str = "Hello World!"
    println(str.addFirst('!'))
    println(str.first())

    // 주의점
    MyExample().printMessage()
    MyExample().printMessage2("확장 함수 출력")
    MyExample().printNullOrNotNull()
    (null as MyExample?).printNullOrNotNull()
}