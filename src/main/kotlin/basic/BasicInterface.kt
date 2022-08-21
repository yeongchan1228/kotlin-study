package basic

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

interface Cart: Wheel {

    var coin: Int

    val weight: String
        get() = "20KG"

    fun add(product: Product)

    fun rent () {
        if (coin > 0) {
            println("카드 대여.")
        }
    }

    override fun roll() {
        println("카트 이동 중...")
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다.")
    }

    fun printId() = println("5678")
}

class MyCart(override var coin: Int = 0): Cart, Order {
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가되었습니다.")

        super<Order>.add(product)
    }

    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product("가방", 10000))
    cart.roll()
    cart.printId()
}