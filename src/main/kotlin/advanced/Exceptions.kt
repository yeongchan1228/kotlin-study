package advanced

import java.io.FileWriter
import java.lang.Exception

fun getStr(): Nothing = throw Exception("예외 발생")

fun main() {

    // 1. Resources
    FileWriter("test.txt")
        .use {
            it.write("Hello Kotlin!")
        }

    // 2. try-catch -> runCatching
    /*
    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본 값"
    }
    println(result)
    */

    val result = runCatching {
        getStr()
    }.getOrElse {
        println(it.message)
        "기본 값"
    }
    println(result)

    val result2 = runCatching {
        getStr()
    }.getOrNull()
    println(result2)

    val result3 = runCatching {
        "성공"
    }.getOrNull()
    println(result3)

    val result4 = runCatching {
        getStr()
    }.exceptionOrNull()
    result4?.let {
        println(it.message)
    }

    val result5 = runCatching {
        getStr()
    }.getOrDefault("실패..")
    println(result5)

    val result6 = runCatching {
        "성공"
    }.map {
        "${it}했습니다!"
    }.getOrThrow()
    println(result6)

    val result7 = runCatching {
        "성공..."
    }.mapCatching { // map {} 에서 Exception 발생 여부가 존재하면 사용
        getStr()
    }.getOrDefault("기본...")
    println(result7)

    val result8 = runCatching {
        getStr()
    }.recover { // Exception 발생 시 동작
        "복구"
    }.getOrNull()
    println(result8)

    val result9 = runCatching {
        getStr()
    }.recoverCatching { // Exception 발생 시 동작
        getStr()
    }.getOrNull()
    println(result9)

    val result910 = runCatching {
        getStr()
    }.getOrThrow()
}