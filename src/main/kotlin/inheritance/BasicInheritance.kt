package inheritance

class Empty // 기본은 final class(상속 X)

open class Dog { // 상속이 가능한 class
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

open class Bulldog(override var age: Int = 0): Dog() {
    override fun bark() {
        println("컹컹")
    }
}

class ChildBulldog: Bulldog() {
    override var age: Int = 0

    final override fun bark() {
        super.bark()
    }
}

abstract class Developer {
    abstract var age: Int
    abstract fun code(language: String)
}

class BackEndDeveloper(override var age: Int = 0): Developer() {
    override fun code(language: String) {
        println("I code with $language")
    }

}

fun main() {

    // 1. Inheritance
    val dog = Bulldog(20)
    println(dog.age)
    dog.bark()

    val childBulldog = ChildBulldog()
    println(childBulldog.age)
    childBulldog.bark()

    // 2. Abstract
    val developer = BackEndDeveloper(age = 30)
    println(developer.age)
    developer.code("Kotlin")
}