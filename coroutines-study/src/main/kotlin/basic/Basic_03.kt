package basic

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    composingExV3()
}

fun composingExV1() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingsUsefulOne()
        val two = doSomethingsUsefulTwo()
        println("The answer is ${one + two}")
    }

    println("Completed in $time ms")
}

fun composingExV2() = runBlocking { // main Thread에서 실행
    val time = measureTimeMillis {
        val one = async { doSomethingsUsefulOne() }
        val two = async { doSomethingsUsefulTwo() }
        println("The answer is ${one.await() + two.await()}. thread = ${Thread.currentThread().name}")
    }

    println("Completed in $time ms. thread = ${Thread.currentThread().name}")
}

fun composingExV3() = runBlocking { // 연산을 나중에 시작
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingsUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingsUsefulTwo() }
        println("start job")
        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()}. thread = ${Thread.currentThread().name}")
    }

    println("Completed in $time ms. thread = ${Thread.currentThread().name}")
}

suspend fun doSomethingsUsefulOne(): Int {
    println("do Somethings one. thread = ${Thread.currentThread().name}")
    delay(1000L)
    return 13
}

suspend fun doSomethingsUsefulTwo(): Int {
    println("do Somethings two. thread= ${Thread.currentThread().name}")
    delay(1000L)
    return 29
}