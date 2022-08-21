package class_property

// class + 생성자
//class Coffee constructor(val name: String) {
//}

// class + 생성자 (생략 가능) + 후행 쉼표 가능 + default 값 추가 가능
class Coffee(
    var name: String = "", // var 키워드 변수는 getter, setter 생성
    var price: Int = 0,
    var iced: Boolean = false,
) {
    val brand: String // val 키워드 변수는 getter 만 생성
        get() = "스타벅스" // custom getter
//        get() = {
//            return "스타벅스"
//        }

    var quantity: Int = 0
        set(value) { // custom setter
            if (value > 0) {
                field = value // field 식별자가 아닌 quantity 사용 시 quantity 가 또 다시 setter 호출 -> stack overflow
            }
        }
}

class EmptyClass

fun main() {

    // 1. Top-Level 클래스 생성 및 필드 변경 + Getter/Setter 자동 생성 후 사용된다.
    val coffee = Coffee()
    coffee.name = "아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true

    if (coffee.iced) {
        println("아이스 아메리카노")
    }
    println("[${coffee.brand}] ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")

}