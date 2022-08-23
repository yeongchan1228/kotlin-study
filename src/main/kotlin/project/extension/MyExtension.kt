package project.extension

fun String.first():Char {
    return this[0]
}

fun String.addFirst(ch: Char): String {
    return ch + this
}

fun main() {
    val str = "test"
    println(str.first())
    println(str.addFirst('!'))
}