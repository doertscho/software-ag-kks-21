# Einführung in die Programmierung mit Kotlin – Woche 1

## Was ist ein Software-Programm? Was ist Programmierung?

Es gibt viele verschiedene Arten von Software-Programmen,
und oft spielen viele verschiedene Arten von Programmen zusammen,
um bestimmte Aufgaben zu erfüllen.

Schon der Aufruf einer Website umfasst beispielsweise diverse Teile:
* Wenn ihr eine WWW-Adresse eintippt,
wird zunächst eine Software aktiv,
die ermittelt, welcher Computer hinter dieser Adresse steckt. 
WWW-Adressen sind dafür gemacht, dass Menschen sie leicht lesen können,
Computer brauchen aber andere Informationen, um miteinander zu kommunizieren.
* Dann wird eine andere Software aktiv,
die eine Verbindung zu diesem anderen Computer aufbaut
und die Daten abruft, die die Website beschreiben.
* Diese Daten reicht sie wiederum weiter an eine andere Software,
die daraus die grafische Aufbereitung ableitet, die euch angezeigt wird –
bestehend aus Texten, Buttons, Bildern,
in einer bestimmten Anordnung, in einer bestimmten Größe und Farbe, und so weiter.
* Auf der Website befinden sich in vielen Fällen Werbeanzeigen –
auch diese werden von einer Software zusammengestellt.
Diese verarbeitet beispielsweise Informationen über eure Interessen,
um abzuschätzen, welche Produkte ihr möglicherweise kaufen wollt.

Eine Definition, die auf fast alle Arten von Software-Programmen zutrifft,
kann wie folgt formuliert werden:

> Ein Programm ist eine präzise definierte Abfolge von _Anweisungen_,
> die ein Computer benötigt,
> um Informationen _(Eingabedaten)_ zu verarbeiten
> und daraus neue Informationen _(Ausgabedaten)_ abzuleiten.

Dies trifft sowohl dann zu, wenn ihr ein Software-Programm als Ganzes betrachtet
(zum Beispiel: die Eingabe ist eine WWW-Adresse,
die Ausgabe eine graphisch aufbereitete, funktionsfähige Website),
als auch dann, wenn ihr die einzelnen Bestandteile einer Software betrachtet.
In vielen Fällen werden die Ausgabedaten eines ersten Teil-Programms
anschließend als Eingabedaten für den nächsten Schritt verwendet.

_Programmierung_ ist das Aufschreiben einer solchen Abfolge von Anweisungen
in einer konkreten Programmiersprache.
Auch Programmiersprachen gibt es viele verschiedene,
die meisten sind auf eine bestimmte Art von Software-Programmen spezialisiert.
Manche unterscheiden sich nur in Details voneinander,
manche verfolgen komplett andere Ansätze als andere.

In dieser AG wollen wir die Programmiersprache **Kotlin** kennenlernen.
Kotlin ist eine vielseitig einsetzbare Sprache,
die sich innerhalb weniger Jahre zu einer der beliebtesten Programmiersprachen entwickelt hat.
Beispielsweise wurden große Teile des Android-Betriebssystems
sowie viele Android-Apps mit Kotlin entwickelt,
ebenso wie die Systeme hinter vielen großen Websites,
komplexe Datenanalyse-Software und künstliche Intelligenzen.

Das meistgenutzte Werkzeug für die Entwicklung von Kotlin-Programmen,
IntelliJ IDEA, ist kostenlos verfügbar (in der "Community Edition").
[Ihr könnt es hier herunterladen.](https://www.jetbrains.com/de-de/idea/download/)

## Ein paar Anmerkungen zum Programmieren lernen

Viele der folgenden Informationen können auf den ersten Blick unklar oder kompliziert wirken.
Am besten lässt sich all dies nach und nach verstehen,
indem ihr alles selbst ausprobiert
und wiederholt kleine Programme schreibt.
Wenn ein Satz im folgenden Text sich euch nicht sofort erschließt,
lasst euch davon bitte nicht abbringen,
mit der praktischen Erfahrung wird sich vieles im Laufe der Zeit ergeben.

Und: Programmieren lernen funktioniert nicht über Auswendiglernen.
Auch professionelle Software-Entwickler*innen nutzen jeden Tag Google
oder andere Suchmaschinen,
und kennen nicht sämtliche Funktionen auswendig,
die eine Programmiersprache wie Kotlin bereitstellt.
Außerdem ist ein Programm wie IntelliJ IDEA hierbei eine große Hilfe.
Es zeigt euch beispielsweise unmittelbar an,
wenn euer Programm Tippfehler enthält,
macht euch Vorschläge und bietet viele zusätzliche Informationen.

## Das einfachste Kotlin-Programm

Kotlin-Programme sind im Prinzip einfache Text-Dateien.
Damit sie von Kotlin verstanden werden, muss der Inhalt bestimmten Regeln folgen.
Diese wollen wir in den nächsten Wochen Schritt für Schritt kennenlernen.

Das kleinstmögliche Kotlin-Programm besteht aus drei Zeilen und sieht wie folgt aus: 

```
fun main() {
  println("Hallo Welt!")
}
```

Es definiert eine sogenannte _Hauptfunktion_ (englisch _"main"_: "Haupt-")
– die oberste Ebene unserer Software –
mit einer einzelnen Anweisung.
Die erste Zeile teilt Kotlin mit, dass es alle folgenden Anweisungen direkt ausführen soll.
Die zweite Zeile enthält die einzige Anweisung des Programms.
Es ist ein Aufruf der vordefinierten Kotlin-Funktion `println`,
die dafür sorgt, dass ein bestimmter Text auf dem Bildschirm ausgegeben wird –
in diesem Fall die Worte "Hallo Welt!".
Die dritte Zeile umfasst nur eine schließende, geschweifte Klammer.
Sie ist das Gegenstück zur öffnenden, geschweiften Klammer in der ersten Zeile,
und sie gibt an, dass an dieser Stelle die Hauptfunktion zu Ende ist.

Um dieses Programm um eine weitere Anweisung zu erweitern,
fügt eine weitere Zeile in der Hauptfunktion ein –
das heißt, zwischen den geschweiften Klammern,
die den Anfang und das Ende der Hauptfunktion markieren.
Zum Beispiel so:

```
fun main() {
  println("Hallo Welt!")
  println("Dies ist mein erstes Kotlin-Programm.")
}
```

Durch einen erneuten Aufruf der vordefinierten Funktion `println`
wird bei der Ausführung des Programms ein weiterer Satz auf dem Bildschirm ausgegeben.

## Funktionen

Kotlin bietet viele vordefinierte Funktionen wie `println`,
die für verschiedenste Aufgaben in einem Programm genutzt werden.
Einige davon werden wir nach und nach kennenlernen.
Zunächst wollen wir uns aber ansehen, wie wir selbst eigene Funktionen definieren können,
und wie wir diese anschließend benutzen können.

Funktionen strukturieren eure Software.
Sie können quasi beliebig tief verschachtelt sein.
Eine Aufgabe eurer Software, die durch eine Funktion repräsentiert wird,
besteht in der Regel aus mehreren Teilaufgaben,
welche dann wiederum durch verschiedene Funktionen definiert werden.
Für jede dieser Funktionen,
egal ob sie auf oberster Ebene euer gesamtes Programm zusammenfasst
oder eine winzige Teilaufgabe definiert,
gilt die obige Definition:
Sie haben Eingabedaten, Ausgabedaten und eine Abfolge von Anweisungen.

## Daten

Was genau sind denn nun diese "Daten", von denen ich hier spreche?
Daten können so ziemlich jede Art von Information sein.
Beispiele für häufig auftauchende Daten in Software sind Zahlen, Namen, Texte und Zeitangaben.
Eine wichtige Unterscheidung:
In manchen Zusammenhängen werden wir in Zukunft von **Werten** reden,
in manchen von **Datentypen**.
Als Datentyp bezeichnen wir eine Gruppe gleichartiger Daten, zum Beispiel: Zahlen.
Ein Wert hingegen ist ein konkretes Element, zum Beispiel: die Zahl 7.
Wir sagen also: Der _Wert_ 7 ist vom _Typ_ "Zahl".

Wenn wir unsere Software später ausführen,
werden wir ihr _konkrete_ Daten als Eingabe geben, also _Werte_.
Da wir unsere Software aber so bauen möchten,
dass sie für alle konkreten Werte funktioniert,
definieren wir unsere Funktionen abstrakt für bestimmte _Typen_ von Daten.
Dies wird vielleicht etwas besser verständlich,
wenn wir uns das folgende Beispiel angucken.

## Eigene Funktionen definieren

Als erstes Beispiel wollen wir eine Funktion definieren,
die eine simple Berechnung durchführt, nämlich:
eine Zahl zu verdoppeln.
Die Funktion hat also als _Eingabe_ eine Zahl,
und auch ihre _Ausgabe_ ist eine Zahl.
Diese Definition von Eingabe- und Ausgabetypen
bezeichnet man in der Programmierung als die **Signatur** einer Funktion.
Mit einer solchen Signatur beginnen wir die Definition einer eigenen Funktion.
Für unsere Verdoppler-Funktion sieht sie wie folgt aus:

```
fun verdopple(eingabe: Int): Int {
```

Das Stichwort `fun` steht hier nicht für Spaß,
sondern als Abkürzung für Funktion.
Wenn der Computer dieses Stichwort "sieht", weiß er Bescheid,
dass nun die Definition einer neuen Funktion folgt.
Als nächstes Wort folgt der Name unserer Funktion.
Diesen können wir völlig frei wählen.
Der Computer versteht in diesem Sinne keine "Menschensprache",
aus seiner Sicht ist es egal,
ob wir unsere Funktion "verdopple", "blabla" oder auch "zypqpufaljf" nennen.
Aber da wir und andere Menschen den Überblick behalten wollen,
tun wir uns selbst einen Gefallen,
wenn wir einen (für Menschen) klar verständlichen Namen wählen.

Die nun folgenden runden Klammern markieren die Definition
der Eingabe- und Ausgabedaten.
Hier könnt ihr euch merken:
_In_ den Klammern stehen die _Eingabedaten_,
_außerhalb_ der Klammern die _Ausgabedaten_.
Für Kotlin interessant ist hier jeweils das Stichwort `Int` –
dieses bezeichnet den Datentyp der ganzen Zahlen (englisch _"integer"_: "ganze Zahl").
Das Wort "eingabe" hingegen ist wiederum ein Name,
den wir frei wählen können.
Wofür wir diesen brauchen, sehen wir gleich.

Am Ende der Zeile steht eine öffnende geschweifte Klammer –
diese zeigt an, dass die Signatur der Funktion abgeschlossen ist,
und in den folgenden Zeilen nun der sogenannte **Rumpf** der Funktion folgt.
Das ist der Fachbegriff für die Abfolge von Anweisungen,
die der Computer benötigt, um aus den Eingabedaten die Ausgabedaten zu berechnen.

Ergänzen wir diesen Rumpf in unserem Beispiel,
dann sieht die vollständige Definition unserer Funktion so aus:

```
fun verdopple(eingabe: Int): Int {
    return eingabe * 2
}
```

Da in diesem Fall nur eine simple Rechenoperation durchgeführt werden muss,
besteht unser Programm-Code für diese Funktion nur aus einer Zeile.
Das Schlüsselwort `return` zeigt an,
dass in dieser Zeile der Ausgabewert (auch Rückgabewert genannt) der Funktion berechnet wird
(englisch _"return"_: "Rückgabe").
Simple mathematische Operationen können in Kotlin so aufgeschrieben werden,
wie wir es auch aus dem Matheunterricht kennen.
Die Verdopplung unserer Eingabezahl können wir also einfach als `eingabe * 2`.
Das Wort `eingabe` ist hier der Name, das wir in der vorherigen Zeile,
der Signatur der Funktion,
für die Eingabezahl festgelegt haben.
Auch hier handelt es sich wieder um eine Bezeichnung,
die vor allem uns als Menschen hilft, unser Programm zu verstehen.
Aus Sicht des Computers ist es auch hier egal,
ob dieser Name "eingabe" oder "x" oder "zahl" oder auch "alkjdsflakdjsfl" heißt.

## Aufrufen von Funktionen

_... Fortsetzung folgt!_