package advanced

import java.time.LocalDateTime

object Singleton {
    val number = 1234

    fun printNumber() = println(number)
}

object DatetimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(aTime: LocalDateTime, bTime: LocalDateTime): Boolean {
        return aTime == bTime
    }
}

class MyClass {

    private constructor()

    companion object MyCompanion {
        val a = 1234

        fun newInstance() = MyClass()
    }
}

fun main() {

    // 1. Singleton
    println(Singleton.number)
    Singleton.printNumber()

    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)

    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))

    // 2. companion object
    println("=============================")
    println(MyClass.a)
    println(MyClass.newInstance())
    println(MyClass.newInstance())

    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())
}
