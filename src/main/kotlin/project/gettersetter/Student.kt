package project.gettersetter

import java.time.LocalDate

class Student {

    @JvmField
    var name: String? = null

    var birthDate: LocalDate? = null

    val age: Int = 10

    var grade: String? = "4.5"
        private set

    fun changeGrade(grade: String) {
        this.grade = grade
    }

}