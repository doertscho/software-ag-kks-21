# Einführung in die Programmierung mit Kotlin – Woche 2

## Neuer Werte-Typ: String für Texte

Unsere erste Funktion verdoppelt eine Zahl.
Als Menschen könnten wir uns denken:
"Verdoppeln" können wir auch andere Sachen, zum Beispiel Worte.
Aus "hallo" würde dann "hallohallo".
Wenn wir aber ohne Weiteres die Funktion `verdopple` aufrufen
mit einem Text als Eingabewert,
wird Kotlin uns einen Fehler anzeigen.
Denn: Wir haben in der Signatur der Funktion `verdopple` definiert,
dass der Eingabewert für diese Funktion vom Typ `Int` (ganze Zahl) sein muss.

Hierfür brauchen wir also eine neue Funktion,
die als Eingabe einen Text-Wert annimmt.
In Kotlin heißt der Datentyp für Text-Werte `String`
(englisch _"string"_: "Kette", in diesem Fall "Zeichenkette").
Und auch die "Rechenanweisung" können wir in Kotlin nicht genau so schreiben
wie bei der Variante für die Zahl.
Stattdessen müssen wir hier eine vordefinierte Funktion aufrufen.
In diesem Fall handelt es sich um die Funktion `repeat` ("wiederhole").
Diese Funktion stellt Kotlin für alle Werte vom Typ "String" bereit.

## Vordefinierte Funktionen für Datentypen

Der Aufruf sieht allerdings etwas anders aus
als bei der vordefinierten Funktion `println`, nämlich so:

```
fun verdoppleText(text: String): String {
  return text.repeat(2)
}
```

Diese zwei Möglichkeiten zum Benutzen einer Funktion gibt es in Kotlin:
Entweder der Name der Funktion steht für sich,
wie bei `println` oder unserer eigenen Funktion `verdopple`,
oder der Name der Funktion wird mit einem Punkt an den Namen des Werts angehängt.
Es ist schwer, klar abzugrenzen, wann diese oder jene Schreibweise verwendet wird.
Tatsächlich liegen die Gründe dafür oft in der historischen Entwicklung von Kotlin
und anderer Programmiersprachen, die als Vorbild verwendet wurden.
Die Schreibweise mit dem Punkt wird euch aber deutlich häufiger unterkommen.
Die meisten vordefinierten Funktionen beziehen sich auf einen Wert eines bestimmten Typs,
und um diesen gewissermaßen in den Mittelpunkt zu rücken,
folgt der Name der Funktion nach dem Wert.

Die intuitive Schreibweise für mathematische Operationen (wie `zahl * 2`)
ist übrigens gewissermaßen nur eine zusätzliche Komfortfunktion von Kotlin.
Bei der Ausführung eures Programms wird so ein Ausdruck automatisch umgewandelt
in einen Funktionsaufruf,
der dem obigen sehr ähnlich sieht.
Im Falle der Multiplikation ist das eine vordefinierte Funktion namens `times`
(englisch _"times"_: "mal", also zum Beispiel _"five times four"_: "fünf mal vier"),
unsere ursprüngliche Funktion `verdopple` könnten wir also auch so schreiben:

```
fun verdopple(zahl: Int): Int {
  return zahl.times(2)
}
```

## Mehrere Eingabewerte

Einer Funktion können wir nicht nur einen Eingabewert mitgeben,
sondern beliebig viele.
In der Funktion `verdopple` wird die gegebene Zahl immer mit dem festen Wert 2 multipliziert.
Wir können aber auch mehrere oder alle in einer Funktion verwendeten Werte dynamisch machen.
Dafür trennen wir mehrere Eingabewerte in der Signatur einfach mit einem Komma.
Die Addition zweier Zahlen könnte zum Beispiel so aussehen:

```
fun addiere(x: Int, y: Int): Int {
  return x + y
}
```

Bei mehreren Rückgabewerten ist es hingegen nicht ganz so einfach.
Das geht auch, aber das werden wir später kennenlernen.

**Beispiele: [HelloWorldExtended](HelloWorldExtended.kt)**

## Eingaben zur Laufzeit einlesen

(Hier fehlt noch ein Abschnitt, wird bald ergänzt!)

**Beispiele: [Energy](Energy.kt)**

## Kommentare

Um gute Software-Programme zu schreiben,
müsst ihr nicht nur dafür sorgen, dass der Computer euch versteht,
es ist auch wichtig, dass andere Menschen euer Programm verstehen –
oder ihr selbst, wenn ihr zu einem späteren Zeitpunkt auf euren Code schaut.
Ein Mittel dafür sind klar verständliche Namen für Funktionen und Werte,
und eine Strukturierung eures Codes durch die Verwendung von Funktionen.

Ein weiteres Hilfsmittel können Kommentare sein.
Eine Zeile in eurem Programm-Code,
die mit zwei Schrägstrichen beginnt (`//`),
wird von Kotlin ignoriert,
und ihr könnt sie nutzen,
um dort in natürlicher Sprache Anmerkungen zu eurem Code zu hinterlassen.

```
// Dies hier ist ein Kommentar!
// Er ist Teil meines Programm-Codes, ist aber einfach in deutscher Sprache geschrieben.
// Zum Beispiel kann ich erklären, was die folgenden Zeilen tun.

// Hier beginnt meine Hauptfunktion:
fun main() {
  // Ich rufe hier zunächst die vordefinierte Funktion `println` auf, um Text auszugeben:
  println("Hallo Welt!")
}
```

## Neuer Werte-Typ: Boolean für Wahrheitswerte

Wir kennen bereits Werte vom Typ `Int`
("integer", englisch für "ganze Zahl")
und Werte vom Typ `String` ("Zeichenkette", also Text).

Diese Woche verwenden wir einen weiteren Typ:
`Boolean` (benannt nach dem Mathematiker George Boole).
Boolean-Werte werden auch als Wahrheitswerte bezeichnet.
Es gibt nur zwei gültige Werte für diesen Typ:
`true` und `false` – wahr und falsch.
In den meisten Fällen lassen sie sich auch verstehen als
"ja" und "nein".

## Neue Struktur: Verzweigungen

Solche Boolean-Werte verwenden wir für Verzweigungen.
Eine Verzweigung ist ein Konstrukt,
mit dem ihr dafür sorgen könnt,
das bestimmte Anweisungen nur unter bestimmten Bedingungen ausgeführt werden.
In Kotlin-Programmen gibt es eine Trennung zwischen Daten und Anweisungen,
über Verzweigungen aber können die konkreten Daten Einfluss nehmen
auf den Ablauf des Programms.

Eine Verzweigung könnt ihr in eurem Programm mit dem Schlüsselwort `if` einleiten.
Dann wird eine Bedingung definiert, die von konkreten Daten abhängt.
Ist diese bei der Ausführung des Codes erfüllt,
wird der folgende Block von Code ausgeführt.
Ansonsten wird der Block nicht ausgeführt.
Es kann aber ein alternativer Block von Code definiert werden,
der in diesem Fall ausgeführt wird.

Beispiele:
```
// nur ein Block für den positiven Fall:
val zahl: Int = bestimmeZahl()
if (zahl > 5) {
  println("Unsere Zahl ist größer als fünf!")
}
```
```
// Blocks für den positiven und den negativen Fall:
val zahl: Int = bestimmeZahl()
if (zahl < 0) {
  println("Unsere Zahl ist negativ, also kleiner als 0!")
} else {
  println("Unsere Zahl ist positiv!")
}
```

Solche Überprüfungen können ebenso durch Funktionsaufrufe definiert werden.
Diese müssen dann einen Boolean-Wert zurückgeben.
```
fun istPrimzahl(x: Int): Boolean {
  [...]
}
[...]

val x: Int = waehleEineZahl()
if (istPrimzahl(x)) {
  println("Die Zahl $x ist eine Primzahl!")
}
```

**Beispiele: [IfElse](IfElse.kt)**