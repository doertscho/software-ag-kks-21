package week2

// Das hier ist ein Kommentar!
// Eine Zeile, die mit // beginnt, wird von Kotlin ignoriert.
// Das könnt ihr nutzen, um Anmerkungen in euren Code zu schreiben – diese können anderen helfen, euren Code zu
// verstehen, oder auch euch selbst als Erinnerung dienen.

// Diese Funktion hat einen Boolean-Wert als Rückgabe. Sie kann also in if-else-Ausdrücken verwendet werden.
// Eine solche Funktion wird auch "Prädikat" genannt.
fun istGerade(zahl: Int): Boolean {
    return zahl % 2 == 0
}

fun geradeOderUngerade() {
    val zahl: Int = readLine()?.toInt() ?: error("Ungültige Eingabe!")
    if (istGerade(zahl)) {
        println("Die Zahl $zahl ist gerade!")
    } else {
        println("Die Zahl $zahl ist ungerade!")
    }
    // Nachdem der if-else-Block ausgeführt wurde, geht es normal weiter im Programmblauf.
    // Der folgende Text wird also immer ausgegeben, egal ob die Zahl gerade oder ungerade war.
    println("Vielen Dank für die Benutzung des Gerade-Ungerade-Checkers!")
}

fun groesserAlsFuenf(zahl: Int): Boolean {
    return zahl > 5
}

fun main() {

    // Hier wird die main-Funktion aufgeteilt, indem ein Teil des Ablaufs in eine eigene Funktion ausgelagert wird:
    geradeOderUngerade()

    val zahl: Int = 8
    if (groesserAlsFuenf(zahl)) {
        println("Die Zahl $zahl ist größer als fünf!")
    } else {
        println("Die Zahl $zahl ist kleiner oder gleich fünf!")
    }

    // Solche "bool'schen Ausdrücke" lassen sich nicht nur für Zahlen definieren, sondern für alle Datentypen:
    print("Bitte gib einen Text ein: ")
    val text: String = readLine() ?: error("Ungültige Eingabe")
    if (text.startsWith("H")) {
        println("Dein eingegebener Text beginnt mit H!")
    } else if (text.startsWith("W")) {
        println("Dein eingegebener Text beginnt mit W!")
    } else {
        println("Dein eingegebener Text beginnt weder mit H noch mit W!")
    }
}
