package project.exception

import java.io.IOException
import kotlin.jvm.Throws

class KotlinThrow {

    fun throwIOException() {
        throw IOException("Checked Exception!!")
    }
    @Throws(IOException::class) // 예외 전파 가능
    fun throwsIOException() {
        throw IOException("Checked Exception!!")
    }

}

fun main() {
    JavaThrow().throwIOException()
    KotlinThrow().throwIOException()
}