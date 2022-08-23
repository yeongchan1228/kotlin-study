package project.jvmstatic

class JvmFieldClass {
    companion object {
        @JvmField
        val id = 1234
        const val CODE = 1234
    }
}

object JvmFieldObject {
    @JvmField
    val name = "Tom"

    const val USERNAME = "Tom"
}

fun main() {
    val id = JvmFieldClass.id

    val name = JvmFieldObject.name
}