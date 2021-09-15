package week2

fun verdopple(x: Int): Int {
    return x * 2
}

fun verdoppleText(text: String): String {
    return text.repeat(2)
}

fun addiere(x: Int, y: Int): Int {
    return x + y
}

fun main() {
    val ergebnis: Int = verdopple(25)
    println(ergebnis)

    val eingabe: Int = 36
    val ergebnis2: Int = verdopple(eingabe)
    println("Das Doppelte von $eingabe ist $ergebnis2")

    val text: String = "Hallo"
    val doppelterText: String = verdoppleText(text)
    println(doppelterText)

    val a: Int = 6
    val b: Int = 9
    val summe: Int = addiere(a, b)
    println("Die Summe von $a und $b ist $summe")
}
