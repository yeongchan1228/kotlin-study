package basic

import kotlinx.coroutines.*

fun main() {
    cancelExV6()
}

fun cancelExV1() {
    runBlocking {
        val job = launch {
            repeat(100) {i ->
                println("job $i")
                delay(500L)
            }
        }

        delay(1000L)
        println("cancel!")
        job.cancel()
        println("finish!")
    }
}

fun cancelExV2() {
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var idx = 0
            while (idx < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("run! ${idx++}")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1000L)
        println("cancel!")
        job.cancelAndJoin()
        println("finish!")
    }
}

fun cancelExV3() { // suspend fun Cancel
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var idx = 0
            while (idx < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    yield()
                    println("run! ${idx++}")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1000L)
        println("cancel!")
        job.cancelAndJoin()
        println("finish!")
    }
}

fun cancelExV4() { // isActive Cancel
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var idx = 0
            while (isActive) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    yield()
                    println("run! ${idx++}")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1000L)
        println("cancel!")
        job.cancelAndJoin()
        println("finish!")
    }
}

fun cancelExV5() { // 리소스 해체 위치
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            try {
                var nextPrintTime = startTime
                var idx = 0
                while (isActive) {
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        yield()
                        println("run! ${idx++}")
                        nextPrintTime += 500L
                    }
                }
            } finally {
                println("Decommissioning of resources.")
            }
        }

        delay(1000L)
        println("cancel!")
        job.cancelAndJoin()
        println("finish!")
    }
}

fun cancelExV6() { // Timeout
    runBlocking {
        // TimeOut 시 Null 반환
        val result = withTimeoutOrNull(1000L) {
            repeat(1000) {
                println("run!!!")
                delay(500L)
            }
            "Done"
        }

        println("result = $result")
    }
}