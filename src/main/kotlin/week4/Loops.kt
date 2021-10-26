package week4

// Eine for-Schleife weist einer Zähler-Variable (oft i genannt, kann aber frei gewählt werden) nacheinander
// die Werte in einem gegebenen Intervall zu und führt den inneren Code für jeden Wert einmal aus.
fun basicForLoop() {
    for (i in 1 .. 10) {
        val double = i * 2
        println("Das Doppelte von $i ist $double")
    }
}

// Dabei kann innerhalb der Schleife nicht nur auf die Zähler-Variable zugegriffen werden, sondern auch auf alle
// außerhalb davon definierten Werte.
fun forLoopWithOuterValue() {
    val other = 1014
    for (i in 12 .. 23) {
        val sum = i + other
        println("Die Summe von $other und $i ist $sum")
    }
}

// Schleifen können beliebig verschachtelt werden. Dafür müssen die Zähler-Variablen unterschiedliche
// Namen erhalten. In diesem Beispiel werden insgesamt 10 · 10 = 100 Multiplikationen durchgeführt.
fun simpleMultiplication() {
    println("Das kleine Einmaleins:")
    for (i in 1 .. 10) {
        for (j in 1 .. 10) {
            val product = i * j
            println("$i mal $j ist $product")
        }
    }
}

// Eine while-Schleife hingegen funktioniert sehr ähnlich wie ein if-else-Ausdruck – mit dem Unterschied,
// dass nach jedem Durchlauf des Codes die Bedingung erneut überprüft wird. Ist sie nach wie vor erfüllt,
// wird der Code ein weiteres Mal ausgeführt. Dies geht so lange, bis die Bedingung zum ersten Mal nicht
// mehr erfüllt ist.
fun whileLoop() {
    var y = 10
    while (y > 3) {
        println("Die Zahl $y ist größer als 3!")
        // Ohne die folgende Zeile würde y sich nie verändern – die Bedingung wäre darum immer erfüllt
        // und die Schleife würde endlos weiterlaufen (das nennt man dann auch "Endlosschleife").
        y = y - 1
    }
    println("Die Schleife ist beendet!")
}

// Für etliche Szenarien ist es ein gängiges Muster, eine Variable als "Zwischenspeicher" zu verwenden,
// der innerhalb einer Schleife kontinuierlich aktualisiert wird:
fun sumOfNumbers() {
    var sum = 0
    for (y in 1 .. 10) {
        sum = sum + y
    }
    println("Die Summe der Zahlen 1 bis 10 ist: $sum")
}

// Die Deklaration des Intervalls in einer for-Schleife kann auch dynamisch geschehen, sprich auch hier
// können die konkret definierten Zahlen durch benannte Werte, Eingabewerte oder Variablen ersetzt werden.
fun sumOfNumbersDynamic(start: Int, end: Int) {
    var sum = 0
    for (y in start .. end) {
        sum = sum + y
    }
    println("Die Summe der Zahlen $start bis $end ist: $sum")
}

// Diese Funktion findet das größte Vielfache von 13 in einem bestimmten Zahlenintervall.
fun greatestMultipleOf13() {
    var result = 0
    for (i in 1 .. 200) {
        if (i % 13 == 0) {
            println("$i ist durch 13 teilbar!")
            result = i
        }
    }
    println("Die größte Zahl (im Bereich 1 bis 100), die durch 13 teilbar ist, ist: $result")
}

// Das funktioniert auch, wenn wir in der for-Schleife von hoch nach niedrig runterzählen.
// Dann brauchen wir aber eine zusätzliche Abfrage, die falsche Aktualisierungen des Zwischenergebnisses verhindert.
fun greatestMultipleOf13CountingDown() {
    var result = 0
    for (i in 400.downTo(1)) {
        if (i % 13 == 0) {
            println("$i ist durch 13 teilbar!")
            if (result < i) {
                result = i
            }
        }
    }
    println("Die größte Zahl (im Bereich 1 bis 200), die durch 13 teilbar ist, ist: $result")
}

fun main() {
    basicForLoop()
    forLoopWithOuterValue()
    simpleMultiplication()
    whileLoop()
    sumOfNumbers()
    sumOfNumbersDynamic(12, 27)
    greatestMultipleOf13()
    greatestMultipleOf13CountingDown()
}
