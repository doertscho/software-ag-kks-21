# Zusammenfassung Woche 4

## Neue Struktur: for-Schleifen

Ein erstes Konzept für die Strukturierung unseres Codes
kennen wir schon, das sind Funktionen.

Neu in dieser Woche ist das Konzept der Schleifen.
Schleifen haben mit Funktionen gemeinsam,
dass sie einen bestimmten Block von Code
wiederverwendbar machen.
Schleifen können
für die wiederholte Ausführung dieses Codes verwendet werden.
Dafür bietet Kotlin mehrere Arten von Schleifen,
von denen wir zunächst zwei betrachten:

Mit dem Schlüsselwort `for` wird eine Schleife eingeleitet,
in der Aktionen
für Werte in einem gegebenen Bereich ausgeführt werden.
Beispiel:
```
for (x in 1 .. 10) {
  val doppelt = x * 2
  println("Das Doppelte von $x ist $doppelt")
}
```
Die einleitende Zeile definiert,
dass der folgende Code je einmal für jede Zahl von 1 bis 10
ausgeführt werden soll.
Der aktuelle Wert soll innerhalb des Code-Blocks
unter dem Namen `x` abrufbar sein.
Dieses Beispiel wird zehn Multiplikationen ausführen
und zehn Zeilen Textausgabe produzieren.

## Neues Schlüsselwort: `var` für veränderliche Werte

Bisher haben wir benannte Werte mit dem Wort `val` eingeleitet,
zum Beispiel: `val meineLieblingsZahl: Int = 42`.
In diesem Fall ist die Zuweisung des Wertes an den Namen fest.
Wir können aber auch erlauben,
dass der einem Namen zugewiesene Wert
zu einem späteren Zeitpunkt verändert wird.
Dafür brauchen wir das Schlüsselwort `var`,
allerdings nur bei der ersten Definition des Namens –
bei späterer Neuzuweisung eines anderen Wertes
darf das Schlüsselwort nicht mehr verwendet werden,
denn es wird ein neuer Wert an einen bestehenden Namen gebunden,
es wird kein neuer Name eingeführt.
Beispiel:
```
var name: String = "Max"
println("Der Name lautet: $name")
name = "Moritz"
println("Jetzt lautet der Name: $name")

// zum Vergleich: Folgendes geht nicht!
val name: String = "Max"
name = "Moritz"

// Folgendes geht auch nicht, zweimal `var` mit demselben Namen:
var name: String = "Moritz"
var name: String = "Max"
```
Grundsätzlich sollten Werte als unveränderlich definiert werden,
also mit dem Wort `val`.
Nur wenn es notwendig ist, sollte `var` verwendet werden.
Eine Anwendung dafür findet sich im Folgenden.

## Neue Struktur: while-Schleifen

Mit dem Schlüsselwort `while` wird eine Schleife eingeleitet,
bei der nicht von vornherein definiert wird,
wie oft sie ausgeführt wird.
Stattdessen wird eine Bedingung definiert,
und so lange diese erfüllt ist, läuft die Schleife weiter.

Eine solche Bedingung
kann auf verschieden Weisen definiert werden.
In allen Fällen muss der Ausdruck zu einem Boolean-Wert
aufgelöst werden können – true oder false.
In diesem Fall stehen diese für Antworten auf die Frage:
Soll die Schleife ein weiteres Mal ausgeführt werden –
ja oder nein?

Ein häufiges Beispiel ist die Überprüfung
eines bestimmten Werts am Anfang der Schleife.
Dies ergibt nur dann Sinn,
wenn es sich um einen veränderlichen Wert handelt (siehe oben),
und dieser im Laufe der Schleifenausführung
auch tatsächlich verändert wird.
So wie hier:
```
var x: Int = 1
while (x < 100) {
  x = x * 2
  println("Unser Wert wurde verdoppelt, er steht jetzt bei $x")
}
println("Die Schleife ist beendet!")
```
Dieser Code wird so lange den Wert von `x` verdoppeln
und entsprechende Textausgaben produzieren,
bis ein Wert von über 100 erreicht ist.
Bei der nächsten Überprüfung wird dann festgestellt,
dass die Bedingung nicht mehr erfüllt ist.
Die Ausführung geht dann in der Zeile nach der Schleife weiter.

**Beispiele: [Loops](Loops.kt)**
