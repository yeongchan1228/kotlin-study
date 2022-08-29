package advanced

data class Car(val name: String)

class CarIterable(private val cars: List<Car> = listOf()) : Iterable<Car> {
    override fun iterator(): Iterator<Car> = CarIterator(cars)
}

class CarIterator(val cars: List<Car> = listOf(), var index: Int = 0) : Iterator<Car> {
    override fun hasNext(): Boolean {
        return cars.size > index
    }

    override fun next(): Car {
        return cars[index++]
    }
}

fun main() {
    val carIterable = CarIterable(listOf(Car("차1"), Car("차2"), Car("차3"), Car("차4")))
    val carIterator = carIterable.iterator()

    while (carIterator.hasNext()) {
        println(carIterator.next())
    }
}
