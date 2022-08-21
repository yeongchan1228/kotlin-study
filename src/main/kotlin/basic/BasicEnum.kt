package basic

enum class PaymentStatus(val label: String): Payable {
    UNPAID("미지급") {
        override fun isPayable() = true
    },
    PAID("지급 완료") {
        override fun isPayable() = false
    },
    FAILED("지급 실패") {
        override fun isPayable() = false
    },
    REFUNDED("환불") {
        override fun isPayable() = false
    };

}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {
    println(PaymentStatus.PAID.label)

    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }

    val paymentStatus = PaymentStatus.valueOf("UNPAID")
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.PAID) {
        println("동일")
    }

    PaymentStatus.values().forEach { paymentStatus -> println("[${paymentStatus}]${paymentStatus.label}") }

    // Enum Class 기본 제공 속성
    println("[${paymentStatus.name}]: ${paymentStatus.ordinal}")
}