package advanced

import java.util.*

fun main() {

    // 1. Immutable List
    val immutableList = listOf("달러", "유로", "원")

    // 2. Mutable List
    val mutableList = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }
//    mutableList.add("달러")
//    mutableList.add("유로")
//    mutableList.add("원")

    // 3. Immutable Set
    val immutableSet = setOf("달러", "유로", "원")

    // 4. Mutable Set
    mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    // 5. Immutable Map
    val immutableMap = mapOf("one" to 1, "two" to 2, "three" to 3)

    // 6. Mutable Map
    val mutableMap = mutableMapOf<String, Int>().apply {
        put("one", 1)
        put("two", 2)
        put("three", 3)
    }
//    mutableMap["one"] = 1
//    mutableMap["two"] = 2
//    mutableMap["three"] = 3

    // 7. Collection Builder 반환 값 -> Immutable
    val buildList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }

    // 8. LinkedList
    val linkedList = LinkedList<Int>().apply {
        add(1)
        add(2)
        add(3)
        addFirst(0)
        add(4)
        addLast(5)
    }

    // 9. ArrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // 10. Iterator
    val iterator = mutableList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("==============")

    for (str in mutableList) {
        println(str)
    }

    println("==============")

    arrayList.forEach {str -> println(str)}
    arrayList.forEach {println(it)}

    println("==============")

    // 11. Map
    val lowerList = listOf("a", "b", "c")
    val upperList = lowerList.map { it.uppercase() }
    upperList.forEach { println(it)}

    println("==============")

    // 12. Filter
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    val evenList =  numberList.filter { it % 2 == 0 }
    val oddList =  numberList.asSequence().filter { it % 2 == 1 }.toList()
    evenList.forEach { println(it) }
    println(oddList)

}