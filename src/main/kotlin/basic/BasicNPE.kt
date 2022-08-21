package npe

import basic.NullSafety

fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?):Int = str?.length ?: 0

fun main() {

    // 1. null 기본
//    val a1: String = null -> null 값 초기화 시 컴파일 오류
    val b1: String = "test"
//    b1 = null -> null 대입 시 컴파일 오류

    // 2. 안전 연산자(?)
    var a2: String ?= null // a Nullable 가능 표시
//    a2.length -> null 값의 길이 출력 시 컴파일 오류 발생
    println(a2?.length) // nullable 설정 출력

    // 3. 엘비스 연산자(?:) -> 좌변이 null 이면 우변 대입
    val a3: String ?= null
    val b3: Int = if (a3 != null) a3.length else 0
    println(b3)

    val c3 = a3?.length ?: 0
    println(c3)

    // 4. Optional 코드 변경
    val nullableStr = getNullStr()
    val length = getLengthIfNotNull(nullableStr)
    val length2 = getLengthIfNotNull("test nullable")
    val length3 = nullableStr?.length ?: "test nullable2"?.length
    println(length)
    println(length2)
    println(length3)

    // 5. NPE 발생 가능 코드 -> 단언 연산자(!!)
//    throw NullPointerException() -> NPE 발생

//    val c5: String? = null
//    val d = c5!!.length -> NPE 발생

//    println(NullSafety.getNullStr().length) -> NPE 발생
    println(NullSafety.getNullStr()?.length ?: 0)

}