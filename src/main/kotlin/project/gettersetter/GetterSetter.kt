package project.gettersetter

fun main() {
    val person = Person()
    person.name = "Tom"
    person.age = 10
    person.address = "Seoul"

    println(person.name)
    println(person.age)
    println(person.address)
    println(person.uuid)
    println(person.myAddress())
}