package week5

fun isPrime(x: Int): Boolean {
    if (x == 1) {
        return false
    }
    for (y in 2 .. (x / 2)) {
        if (x % y == 0) {
            return false
        }
    }
    return true
}

fun faculty(x: Int): Int {
    var multiplier: Int = 1
    var result = 1
    while (multiplier <= x) {
        result *= multiplier
        multiplier++
    }
    return result
}

fun faculty2(x: Int): Int {
    if (x < 2) {
        return 1
    }
    return x * faculty2(x - 1)
}

fun main() {
    while (true) {
        print("Bitte gib eine Zahl ein: ")
        val num = readLine()?.toInt() ?: error("Ungültige Eingabe!")
        if (isPrime(num)) {
            println("Die Zahl $num ist eine Primzahl!")
        } else {
            println("Die Zahl $num ist keine Primzahl.")
        }

        val numFaculty = faculty(num)
        println("$num! = $numFaculty")

        val numFaculty2 = faculty2(num)
        println("$num! = $numFaculty2")
    }
}
