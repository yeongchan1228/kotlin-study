package basic

fun main() {
    flowControlIfElse()

    flowControlWhen()

    flowControlForLoop()

    flowControlWhile()
}

private fun flowControlIfElse() {
    println("==========if-else==========")

    // if-else (1)
    val job = "Study-Kotlin"

    if (job == "Study-Kotlin") {
        println("success")
    } else {
        println("fail")
    }

    // if-else (2)
    val age: Int = 10

    val str = if (age > 10) {
        "성인"
    } else {
        "아기"
    }

    // if-else (3)
    val a: Int = 10
    val b: Int = 20
    var c = if (a < b) b else a

    println(c)
}

private fun flowControlWhen() {
    println("==========when==========")

    // when (1)
    val day: Int = 2
    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        5 -> "금요일"
        else -> "주말"
    }
    println(result)

    val result2 = when (getColor()) {
        Color.RED -> "red"
        Color.GREEN -> "green"
        else -> "blue"
    }
    println(result2)

    // 여러 조건을 한 줄에 표현 가능
    val result3 = when (getColor()) {
        Color.RED, Color.BLUE -> "main"
        Color.GREEN -> "other"
    }
    println(result3)
}

private fun flowControlForLoop() {
    println("==========For-Loop==========")

    // 범위 연산자 .. 을 사용한 for loop
    for (i in 0..3) {
        println(i)
    }

    // downTo 값까지 감소
    for (i in 5 downTo 2) {
        println(i)
    }

    // until 사용 뒤의 숫자 포함 X
    for (i in 0 until 3) {
        println(i)
    }

    // step 값 만큼 증가
    for (i in 0 until 4 step 2) {
        println(i)
    }

    // 배열 반복
    val numbers = arrayOf(1, 2, 3, 4, 5)
    for (number in numbers) {
        println(number)
    }

}

private fun flowControlWhile() {
    println("==========while==========")

    var x = 5;
    // 자바와 동일
    while (x > 0) {
        println(x)
        x--
    }
}

enum class Color {
    RED, GREEN, BLUE
}

fun getColor() = Color.RED