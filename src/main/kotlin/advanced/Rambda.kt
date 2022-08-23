package advanced

fun main() {

    // 1
    val hello: () -> Unit = { println("Hello") }
    val mutableList = mutableListOf(hello)
    val getItem = mutableList[0]
    getItem()

    // 2
    call(hello)

    // 3
    val mutableFunList = mutableListOf(printNo())
    mutableFunList[0]

    // 4
    val printMessage: (String) -> Unit = {message: String -> println(message)}
    printMessage("test...")

    // 5
    val printMessage2: (String) -> Unit = { println(it) }
    printMessage2("test2...")

    // 6
    val plus: (Int, Int) -> Int = {a: Int, b: Int -> a + b}
    println(plus(10, 20))

    // 7
    val plus2: (Int, Int) -> Int = {a, b -> a + b}
    println(plus2(10, 20))

    // 8
    val stringList = listOf("A", "B", "C", "D")
    val printStr: (String) -> Unit = { println(it) }
    forEachStr(stringList, printStr)
    forEachStr(stringList) { println(it) } // 후행 람다식

    // 9
    val func = outerFun()
    func()
    outerFun2()()

    // 10
    val sum = {x: Int, y: Int -> x + y}
    println(sum(10, 20))

    // 11
    val printNo = ::printNo
    printNo()

    val numberList = listOf("1", "2", "3")
    numberList.map { it.toInt() }.forEach { println (it) }
    numberList.map(String::toInt).forEach(::println)
}

fun outerFun(): () -> Unit {
    return fun() {
        println("익명 함수")
    }
}

fun outerFun2(): () -> Unit {
    return {
        println("익명 함수")
    }
}

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

fun call(block: () -> Unit) {
    block()
}

fun printNo() = println("No!!")