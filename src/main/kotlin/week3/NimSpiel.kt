package week3

// Ein paar Notizen – auf Deutsch, nicht auf Kotlin – zum Beginn:
// Was muss mein Programm können?

// Eingabemöglichkeit: 1, 2 oder 3 Hölzer
// Zahl der übrigen Hölzer anzeigen
// Ausgabe, wer gewonnen hat
// Ausgabe, wer an der Reihe ist
// Programm muss reagieren auf Eingabe und den Spielzustand anpassen



// Die simpelste KI, die wir schreiben können: Sie gibt einfach immer den gleichen Zug zurück.
// Aber: Zumindest kann diese "KI" immer einen Zug ausgeben, und dieser Zug ist immer ein gültiger Zug.
// Wir können das Spiel also gegen diese KI spielen.
fun kiZugVersion1(anzahlHoelzer: Int): Int {
    return 1
}

// Eine leichte Verbesserung unserer ersten Version: Diese "KI" überprüft, ob sie das Spiel im aktuellen
// Zug gewinnen kann, und wenn ja, nimmt sie die entsprechende Anzahl an Hölzern.
fun kiZugVersion2(anzahlHoelzer: Int): Int {
    if (anzahlHoelzer < 4) {
        return anzahlHoelzer
    }
    return 1
}

// Hier eine dritte Version: Diese KI verfolgt die ideale Gewinnstrategie für das Nim-Spiel. Wenn die Gegenspielerin
// eine Anzahl Hölzer vor sich liegen hat, die ein Vielfaches von vier ist, kann sie das Spiel nicht gewinnen, und
// nicht verhindern, dass wir ihr im nächsten Zug wieder ein Vielfaches von vier übergeben.
fun kiZugVersion3(anzahlHoelzer: Int): Int {
    // Die Modulo-Operation ist hierfür sehr hilfreich. anzahl % 4 bedeutet so viel wie, welcher
    // Rest bleibt übrig bei der Division der Anzahl durch vier?
    val rest: Int = anzahlHoelzer % 4
    if (rest == 0) {
        return 1
    } else {
        return rest
    }
}

fun menschlicherZug(anzahlHoelzer: Int): Int {
    print("Es gibt noch $anzahlHoelzer Hölzer, wie viele Hölzer möchtest du nehmen? Bitte gib 1, 2 oder 3 ein: ")
    val eingabe: String = readLine() ?: error("Ungültige Eingabe!")
    return eingabe.toInt()
}

val mensch = "Mensch"
val ki = "KI"

fun runde(anzahlHoelzer: Int, aktuelleSpielerin: String) {

    // Gib aktuellen Spielzustand an
    println("")
    println("Es liegen noch $anzahlHoelzer Streichhölzer auf dem Tisch.")
    println("Als nächstes ist an der Reihe: $aktuelleSpielerin")

    // Frage nächsten Zug ab, je nachdem, ob Mensch oder KI an der Reihe ist
    val hoelzerGenommen: Int
    if (aktuelleSpielerin == mensch) {
        hoelzerGenommen = menschlicherZug(anzahlHoelzer)
    } else {
        hoelzerGenommen = kiZugVersion3(anzahlHoelzer)
    }
    println("$aktuelleSpielerin nimmt $hoelzerGenommen Hölzer")

    // Überprüfe Gültigkeit der Eingabe
    if (hoelzerGenommen > 3 || hoelzerGenommen < 1) {
        error("Du darfst nur ein, zwei oder drei Hölzer nehmen!! $aktuelleSpielerin wird disqualifiziert.")
    }

    // Berechne neuen Spielzustand
    val neueAnzahlHoelzer = anzahlHoelzer - hoelzerGenommen

    val neueAktuelleSpielerin: String
    if (aktuelleSpielerin == mensch) {
        neueAktuelleSpielerin = ki
    } else {
        neueAktuelleSpielerin = mensch
    }

    // Überprüfe, ob das Spiel beendet ist oder die nächste Runde begonnen werden muss
    if (neueAnzahlHoelzer < 1) {
        println("Herzlichen Glückwunsch, $aktuelleSpielerin gewinnt!")
    } else {
        runde(neueAnzahlHoelzer, neueAktuelleSpielerin)
    }
}

fun main() {

    // Starte das Spiel mit der ersten Runde und dem Startzustand (21 Hölzer)
    runde(21, ki)
}
