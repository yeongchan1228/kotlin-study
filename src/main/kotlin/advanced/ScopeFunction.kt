package advanced

import java.util.StringJoiner

class DataBaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    fun connect(): Boolean {
        println("DB 접속 중...")
        Thread.sleep(1000)
        println("DB 접속 완료!")

        return true
    }
}

class User(private val name: String, private val password: String,) {
    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증 성공!")
        } else {
            println("검증 실패!")
        }
    }
}

fun main() {

    // 1. let -> 마지막 코드가 반환 값
    var str: String? = null
    str?.let {
        println(it)
    }

    str = "Hello"
    val result: Int? = str?.let {
        println(it)

        val abc: String? = "abc"
        abc.let {
            val def: String? = "def"
            def?.let {
                println(it)
            }
            println(abc)
        }

        1234
        5678
    }
    println(result)

    // 2. run
    println("=============================")
//    val config = DataBaseClient()
//    config.url = "localhost:5678"
//    config.username = "root"
//    config.password = null
//    println(config.connect())

    val connected = DataBaseClient().run {
        this.url = "localhost:5678"
        username = "root"
        password = null

        connect()
    }
    println(connected)

    // 3. with
    val length = with("test") {
        length
    }
    println(length)

    // 4. apply
    val dataBaseClient = DataBaseClient().apply {
        url = "localhost:5678"
        username = "root"
        password = null
    }
    println(dataBaseClient.connect())
    dataBaseClient.connect().run { println(this) }

    // 5. also
    User(name = "test", password = "1234").also {
        it.validate()
    }

}