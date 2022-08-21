package exception

import java.lang.Exception
import java.lang.IllegalArgumentException

fun main() {

    // 1. Checked Exception -> 예외 처리(try-catch)를 강제하지 않는다.
    Thread.sleep(1)

//    try {
//        Thread.sleep(1)
//    } catch (e: Exception) {
//        // 예외 처리 로직
//    } finally {
//        // finally 처리
//    }

    // 2. try-catch를 표현식 형태로 작성 가능
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생")
    }
    println(a)

    // 3. 예외 발생
//    failException("Test Exception")
//    println("메시지 출력?") -> 반환 타입 Nothing에 의해 Unreachable code 메시지 경고 발생

    val b: String? = null
    val c = b ?: failException("b is null")

    println(c.length)
}

fun failException(message: String): Nothing {
    throw IllegalArgumentException(message)
}