package thread

import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun main() {
    printCurrentThread()

    useThreadPool()

    useFuture()

    userCompletableFuture()
}

private fun userCompletableFuture() {
    val completableFuture = CompletableFuture.supplyAsync {
        Thread.sleep(2000)
        100 + 200
    }

    println("계산 시작")
    completableFuture.thenApplyAsync(::println)

    while (!completableFuture.isDone) {
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다..")
    }
    println("계산 종료")
}

private fun useFuture() {
    val executor = Executors.newSingleThreadExecutor()
    val future = executor.submit(Callable {
        100 + 200
    })

    println("계산 시작")
    val result = future.get()
    println(result)
    println("계산 종료")
}

private fun useThreadPool() {
    val fixedThreadPool = Executors.newFixedThreadPool(5)

    try {
        for (i in 0 .. 5) {
            fixedThreadPool.execute {
                println("current thread : ${Thread.currentThread().name}")
            }
        }
    } finally {
        fixedThreadPool.shutdown()
    }

    println("current thread : ${Thread.currentThread().name}")
}

private fun printCurrentThread() {
    for (i in 0 until 5) {
        val thread = Thread {
            println("current thread : ${Thread.currentThread().name}")
        }
        thread.start()
    }

    println("current thread : ${Thread.currentThread().name}")
}