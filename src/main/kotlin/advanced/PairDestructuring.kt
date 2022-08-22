package advanced

fun plus(a: Int, b: Int) = a + b

data class Tuple(val a: Int, val b: Int)

fun plusTuple(tuple: Tuple) = tuple.a + tuple.b

fun plusPair(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    println(plus(10, 20))
    println(plusTuple(Tuple(10, 20)))
    println(plusPair(Pair(10, 20)))

    // 1. Pair
    val pair = Pair("A", 10)
//    pair.first = "B" -> 에러 발생, 불변 객체
    val copyPair = pair.copy(first = "B")
    println(pair)
    println(copyPair)

    val copyPairList = copyPair.toList()
    for (value in copyPairList) {
        println(value)
    }

    // 2. Triple
    val triple = Triple(10, 20, 30)
    println(triple)

    // 3. Destructing
    val (v1, v2, v3) = triple
    println("$v1, $v2, $v3")

    val mutableMap = mutableMapOf("test1" to 10, Pair("test2", 20))
    for ((key, value) in mutableMap) {
        println("$key, $value")
    }
}