# Zusammenfassung Woche 5

## Neuer Werte-Typ: Listen

Bisher haben wir jeweils mit Werte-Typen gearbeitet,
die jeweils einen einzelnen Wert ausdrücken.
Diese Typen (z.B. Zahlen oder Wahrheitswerte)
werden auch als primitive Datentypen bezeichnet –
sie stellen praktisch die Grundbausteine dar.
Unsere Möglichkeiten werden aber um ein Vielfaches erweitert,
wenn wir diese Typen dynamisch kombinieren.
Die erste Möglichkeit dafür sind Listen.

Listen enthalten eine beliebige Zahl von konkreten Werten.
Bei der Deklaration eines Listen-Werts kann definiert werden,
welchen Typ die Elemente haben.
Für eine Liste von ganzen Zahlen (Typ "Int")
sieht das zum Beispiel so aus:
```
val listeVonZahlen: List<Int> = listOf(5, 14, 3, 8, 0)
```

Der große Vorteil von dynamischen Datentypen wie Listen ist,
dass wir nun Code schreiben können,
der unabhängig von der Menge an Daten funktioniert.
Wenn wir an einer Stelle in unserem Code definieren,
dass ein bestimmter Wert zum Beispiel
vom Typ "Liste von Zahlen" ist,
stellt Kotlin sicher,
dass der Code für jegliche solche Liste funktioniert –
sei es eine Liste mit 3, 1000 oder einer Million Werten,
oder auch eine leere Liste ohne Inhalt.

Listen können als Eingabemenge für `for`-Schleifen
verwendet werden.
In bisherigen Beispielen haben wir definiert,
dass die Schleife beispielsweise
für alle Werte zwischen 1 und 20 ausgeführt werden soll.
Genau so können wir nun angeben,
dass die Schleife
für alle Werte in einer Liste ausgeführt werden soll:
```
val meineLieblingsZahlen: List<Int> = listOf(3, 4, 12, 24, 27)
for (x in meineLieblingsZahlen) {
  println("$x ist eine meiner Lieblingszahlen!")
}
```

Durch die Kombination einer solchen `for`-Schleife
mit veränderlichen Helfer-Variablen
können wir die Werte in unserer Liste untersuchen,
ohne dass wir vorher wissen müssen,
welche oder wie viele Werte darin stehen:
```
val listeVonZahlen: List<Int> = listOf(21, 4, 26, 12, 11, 0, 4, 34, 141, 57, 424)

var bisherGroessteZahl: Int = -1
for (x in listeVonZahlen) {
    if (x > bisherGroessteZahl) {
        bisherGroessteZahl = x
    }
}
println("Die größte Zahl in der Liste ist: $bisherGroessteZahl")
```

**Beispiele: [ListsArrays](ListsArrays.kt)**

## Neues Konzept: Objektorientierte Aufrufe

Für die Arbeit mit Listen (wie auch mit anderen Typen)
stellt Kotlin eine große Menge an Standard-Funktionen bereit.
Ein paar Beispiele:
```
val listeVonZahlen: List<Int> = listOf(5, 1, 57, 23, 1, 11, 31)
val sortierteListe = listeVonZahlen.sorted()
val groesstesElement = listeVonZahlen.max()
val zufaelligAusgewaehltesElement = listeVonZahlen.random()
```

Es fällt auf:
Verglichen mit dem bekannten Format von Funktionsaufrufen (`funktionsName(eingabeWert)`)
wird hier eine andere Reihenfolge verwendet (`wert.funktionsName()`).
Dies wird auch als objektorientierter Funktionsaufruf bezeichnet.
Es besteht kein grundsätzlicher Unterschied zwischen beiden Arten,
und in vielen Fällen wäre es uns ohne Weiteres möglich,
die Funktionen auch auf die jeweils andere Weise zu definieren.
Die feinen Unterschiede lernen wir noch kennen.

In erster Linie ist es Geschmackssache und persönliches Ermessen,
ob die eine oder andere Art der Definition für eine Funktion sinnvoller ist.
Die objektorientierte Variante wird in der Regel dann verwendet,
wenn eine Funktion ganz klar im Kontext eines konkreten Wertes zu sehen ist.
Steht eine Funktion für sich und hat mehrere Eingabewerte,
wird tendenziell eher die bisher bekannte Variante verwendet.

Auch für objektorientierte Funktionsaufrufe
können aber weitere Eingabewerte erforderlich sein.
Beispiel: Die Funktion, die einen Text in eine Liste von Texten zerlegt,
anhand eines bestimmten Trennzeichens.
Diese wird im Kontext des Text-Wertes objektorientiert aufgerufen,
benötigt aber einen weiteren Eingabewert, nämlich das zu verwendende Trennzeichen.
```
val eingabeText: String = "wort,hallo,apfel,birne,zitrone"
val trennzeichen = ","
val einzelneWorte: List<String> = eingabeText.split(trennzeichen)
```

## Arrays

Wir kennen bereits Listen,
die eine Menge von verschiedenen Werten
in festgelegter Reihenfolge enthalten.
Eine ähnliche Datenstruktur sind Arrays,
auch sie enthalten eine Menge von Werten
in festgelegter Reihenfolge.
Im Unterschied zu Listen sind Arrays jedoch darauf spezialisiert,
auf die Werte jeweils einzeln zuzugreifen
und sie gegebenenfalls auch einzeln zu verändern.
Anstelle einer Auflistung von Werten
könnt ihr euch Arrays also eher
als eine Reihe von Schubladen vorstellen,
die jeweils einen Wert enthalten.

```
val arrayOfNumbers: Array<Int> = arrayOf(14, 11, 14, 184, 58)

// Wir fangen bei 0 an zu zählen – der erste Wert hat Index 0
val theFirstValue: Int = arrayOfNumbers[0]
val theSecondValue: Int = arrayOfNumbers[1]

// Wir können einzelne Einträge gezielt verändern:
val oldFourthValue = arrayOfNumbers[3] // das ist 184
arrayOfNumbers[3] = 571
val newFourthValue = arrayOfNumbers[3] // das ist 571
```

Arrays können ineinander verschachtelt werden,
um zweidimensionale Strukturen abzubilden
(oder auch drei- oder höherdimensionale).
Ein Array, dessen einzelne Einträge wiederum Arrays sind,
kann so verwendet werden,
um beispielsweise eine quadratisch angeordnetes Spielfeld
mit Reihen und Spalten abzubilden.

```
val sudokuCell: Array<Array<Int>> = arrayOf(
    arrayOf(5, 1, 4),
    arrayOf(2, 3, 9),
    arrayOf(7, 8, 6)
)
// Zugriff auf die zweite Zeile, drittes Feld:
// (Erinnerung, es wird jeweils bei 0 angefangen zu zählen!)
val middleRight: Int = sudokuCell[1][2]
```

**Beispiele: [ListsArrays](ListsArrays.kt)**
