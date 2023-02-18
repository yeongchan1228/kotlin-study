package basic

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
//   exV1()

//   exV2()

//   exV3()

//   exV4()

//   exV5()

//   exV6()

   exV7()
}


fun exV1() {
   coroutine()

   println("Hello, ")
   Thread.sleep(2000L);
}

fun exV2() {
   thread()

   println("Hello, ")
   Thread.sleep(2000L);
}

fun exV3() {
   coroutine()

   println("Hello, ")
   blockingCoroutine()
}

fun exV4() = runBlocking {
   coroutine()

   HelloPrint()
   delay(2000)
}

fun exV5() = runBlocking {
   val job = coroutine()

   HelloPrint()
   job.join()
}

fun exV6() = runBlocking {
   launch {
      WorldPrint()
   }

   HelloPrint()
}

fun exV7() {
   runBlocking {
      repeat(100000) {
         launch {
            delay(1000L)
            println(".")
         }
      }
   }
}

fun blockingCoroutine() {
   runBlocking {
      delay(1000L)
   }
}

fun coroutine() : Job {
   return GlobalScope.launch {
      WorldPrint()
   }
}

fun thread() {
   thread {
      Thread.sleep(1000L)
      println("World!")
   }
}

fun HelloPrint() {
   println("Hello, [" + Thread.currentThread().name + "]")
}

suspend fun WorldPrint() {
   delay(1000L)
   println("World! [" + Thread.currentThread().name + "]")
}