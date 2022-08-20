package function

// 기본적인 함수 선언 스타일
fun sum(a: Int, b: Int) : Int {
    return a + b
}

// 표현식 스타일
fun sum2(a: Int, b: Int) : Int = a + b

// 표현식 & 반환 타입 생략
fun sum3(a: Int, b: Int) = a + b

// 몸통 있는 함수는 반환 타입 제거 시 오류
fun sum4(a: Int, b: Int) {
//    return a + b; -> 오류
}

// 반환 타입이 없는 함수의 경우 Unit을 반환한다. ( : Unit 생략)
fun printSum(a: Int, b: Int) {
    println("$a + $b = ${a + b}")
}

// default parameter
fun greeting(message: String = "안녕하세요.") {
    println(message)
}

fun log(level: String = "INFO", message: String) {
    println("[$level]$message")
}

fun name(name: String = "default") = println(name)
fun name2(name: String = "default") = println("$name")

fun main() {
    println(sum(10, 20))
    println(sum2(10, 20))
    println(sum3(10, 20))
    printSum(10, 20)
    greeting()
    greeting("Hello World!")

    // Named Argument
    log(message = "INFO LOG")
    log(level = "DEBUG", "DEBUG LOG")
    log("WARN", "WARN LOG")
    log(level = "ERROR", message = "ERROR LOG")

    name()
    name("myName")
    name2("myName")
}