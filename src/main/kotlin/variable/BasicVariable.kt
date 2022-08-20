package variable

var x = 5;
fun main() {

    // 1. val(불변)
    val a : Int = 1;

    // 2. 타입 생략
    val b = 1;
//    b = 2; -> 오류

    // 3. 지연 할당 (타입을 명시해야 한다.)
    val c : Int;
    c = 3;

    // 4. var(가변)
    var d = 4;
    d = 5;

    // 5. 값 추론 오류
    var i = "hi";
//    i = 123; -> 오류

    // 6. Top Level Variable
    x += 5;
    println(x);
}