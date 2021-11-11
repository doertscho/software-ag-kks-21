# Zusammenfassung Woche 6

Diese Woche lernen wir neue Möglichkeiten
für die sogenannte "Datenmodellierung" kennen –
die strukturierte Beschreibung der Werte,
mit denen wir arbeiten wollen.
Wir kennen schon die Basis-Datentypen
`Int` (Zahlen), `String` (Texte) und `Boolean` (Wahrheitswerte).
Außerdem haben wir schon Listen und Arrays verwendet.
Diese Woche kommen ein paar weitere Konzepte dazu.

## Enumerationen

Durch die Schlüsselworte `enum class` können wir
einen eigenen Datentypen definieren,
der eine feste, abgeschlossene Menge von möglichen Werten umfasst.
Diese nennen sich auch Enumerationen.
Sie sind immer dann nützlich, wenn wir wissen,
dass in einer Situation
nur ganz bestimmte Werte sinnvoll möglich sind.

```
// Definition möglicher Produkt-Kategorien in einem Online-Shop:
enum class Category {
    Electronics,
    Toys,
    Sports,
    Household,
    Books,
    Clothing
}

// Definition der Spielfigur-Arten beim Schach:
enum class ChessPieceType {
    Queen,
    King,
    Bishop,
    Rook,
    Knight,
    Pawn
}
```

Wenn ein Wert vom Typ einer bestimmten Enumeration sein soll,
wir aber einen Wert zuweisen,
der nicht als gültiger Wert definiert wurde,
dann wird Kotlin dies automatisch als Fehler erkennen.

**Beispiele: [DataModeling](DataModeling.kt)**

## Datenklassen

Die Schlüsselworte `data class` leiten die Definition
einer sogenannten "Datenklasse" ein.
Diese können wir dafür nutzen, Werte auszudrücken,
die aus mehreren Bestandteilen zusammengesetzt sind.
Für jeden dieser Teil-Werte muss festgelegt werden,
welchen Typ dieser hat.

```
// Daten einer Person, z.B. in einer Kontaktliste:
data class Person {
    val firstName: String,
    val lastName: String,
    val yearOfBirth: Int,
    val telephoneNumber: Int,
    val emailAddress: String
}

// Informationen über ein Buch, z.B. für eine Bibliotheks-Verwaltung:
data class Book {
    val author: String,
    val title: String,
    val publicationYear: Int
}
```

Bei der Zuweisung eines solchen komplexen Werts
müssen entsprechend die definierten Bestandteile angegeben werden,
später können diese wiederum einzeln abgefragt werden.

```
val myBook: Book = Book("Arthur McAuthor", "The Book Of Doom", 2016)
val titleOfMyBook: String = myBook.title
```

**Beispiele: [DataClasses](DataClasses.kt), [ChessBoard](ChessBoard.kt)**

## Nullable Types

Egal, an welcher Stelle Werte oder Variablen auftauchen,
oft ist es nützlich oder erforderlich, anzugeben,
dass an dieser Stelle kein richtiger Wert steht.
Das kann daran liegen, dass der Wert noch nicht bekannt ist,
oder dass es keinen gibt.
Viele Programmiersprachen lassen dies ohne gesonderte Absicherung zu,
dies hat allerdings immer wieder zu Problemen geführt.
Kotlin erfordert darum eine ausdrückliche Angabe,
ob solche "leeren" Werte möglich sein sollen.

Der Ausdruck für einen solchen leeren Wert in Kotlin ist `null` –
und zwar gleichermaßen für alle Datentypen.
Es wird daher auch als Nullwert bezeichnet.
`null` darf nicht verwechselt werden mit der Zahl `0`
oder mit dem Text `"null"`,
nur ausgeschrieben und ohne Anführungszeichen
bezeichnet es den leeren Wert.

Bei der Angabe eines Wert-Typen
(bei der Definition eines benannten Werts, einer Variablen,
oder in der Signatur einer Funktion)
muss explizit angegeben werden,
ob Nullwerte zugelassen werden sollen.
Falls ja, muss dem Typen ein `?` angehängt werden.
Falls nein, wenn der Typ als ohne `?` angegeben wird,
wird Kotlin jede Situation,
in der ein Nullwert zugewiesen wird oder zugewiesen werden könnte,
als Fehler melden.
Wird ein Fragezeichen angehängt,
bezeichnet man den Typen auch als "Nullable Type".

```
// hier dürfte NICHT null zugewiesen werden:
val text1: String = "ababa abaca accacaca"
// hier darf null zugewiesen werden, oder ein tatsächlicher Wert:
val text2: String? = null
val text3: String? = "hallo welt"

// ACHTUNG: null ist nicht zu verwechseln mit ...
val number: Int = 0                 // ... der Zahl 0
val text: String = "null"           // ... dem Text "null" (vier Buchstaben)
val booleanValue: Boolean = false   // ... dem Wahrheitswert "falsch"
val text: String = ""               // ... dem leeren Text (mit null Buchstaben)
val list: List<String> = listOf()   // ... einer leeren Liste (mit null Elementen)
```

Taucht an einer Stelle ein "null-barer" Wert auf,
es wird aber für die weitere Verwendung
ein nicht-null-barer Wert benötigt,
gibt es mehrere Möglichkeiten zur Umwandlung.
Es kann mit den Zeichen `?:` ein Standardwert angegeben werden,
der verwendet wird, falls ein Nullwert vorliegt.
Auch kann Kotlin angewiesen werden,
in diesem Fall einen Fehler auszugeben.
Manche Typen definieren auch weitere Hilfsfunktionen.

```
val nullableText1: String? = null
val nullableText2: String? = "hier steht tatsächlich text"
val text1: String = nullableText1 ?: "standard"
val text2: String = nullableText2 ?: "standard"
// text1 wird nun den Wert "standard" enthalten,
// text2 jedoch den Text, der in nullableText2 steht.

// Kotlin kann auch angewiesen werden, bei Null-Werten einen Fehler zu werfen:
val input: String? = readLine()
val safeInput: String = input ?: error("input was null!")

// Manche Datentypen bieten weitere Funktionen, z.B. Listen:
val nullableList: List<Int>? = null
// Die folgende Funktion verwendet eine leere Liste,
// falls der Ursprungswert null ist:
val list: List<Int> = nullableList.orEmpty()
// Dieser Funktionsaufruf ist identisch mit folgender Schreibweise:
val list2: List<Int> = nullableList ?: listOf()
```

**Beispiele: [DataModeling](DataModeling.kt)**
