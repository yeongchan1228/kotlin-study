package advanced

data class Person(val name: String, val age: Int,)

fun main() {
    val person1 = Person(name = "test", age = 10)
    val person2 = Person(name = "test", age = 10)

    // 1. equals()
    println(person1 == person2)

    // 2. hashCode()
    println("=============================")
    println(person1.hashCode() == person2.hashCode())
    val hashSet = hashSetOf(person1)
    println(hashSet.contains(person2))

    // 3. toString()
    println("=============================")
    println(person1.toString())
    println(person2.toString())

    // 4. copy() -> 불변성을 위해 copy() 한 후 고쳐서 사용하는 것이 좋다.
    println("=============================")
    val copyPerson = person1.copy(name = "modify")
    println(person1)
    println(copyPerson)

    // 5. property 접근
    println("=============================")
    println("이름 = ${person1.name}, 나이 = ${person1.age}")
    println("이름 = ${person1.component1()}, 나이 = ${person1.component2()}")
    val (name, age) = person1 // 구조 분할
    println("이름 = $name, 나이 = $age")
}