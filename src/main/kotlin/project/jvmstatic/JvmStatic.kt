package project.jvmstatic

import kotlin.jvm.JvmStatic

object HiObject {
    @JvmStatic
    fun hi() = "hi!"
}

class HelloClass {
    companion object {
        @JvmStatic
        fun hello() = "hello!"
    }
}

fun main() {
    println(HiObject.hi())
    println(HelloClass.hello())
}