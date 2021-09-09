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
die daraus die graphische Aufbereitung ableitet, die euch angezeigt wird –
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

In dieser AG wollen wir die Programmiersprache **Kotlin** kennen lernen.
Kotlin ist eine vielseitig einsetzbare Sprache,
die sich innerhalb weniger Jahre zu einer der beliebtesten Programmiersprachen entwickelt hat.
Beispielsweise wurden große Teile des Android-Betriebssystems
sowie viele Android-Apps mit Kotlin entwickelt,
ebenso wie die Systeme hinter vielen großen Websites,
komplexe Datenanalyse-Software und künstliche Intelligenzen.

Das meistgenutzte Werkzeug für die Entwicklung von Kotlin-Programmen,
IntelliJ IDEA, ist kostenlos verfügbar (in der "Community Edition").
[Ihr könnt es hier herunterladen.](https://www.jetbrains.com/de-de/idea/download/)

## Das einfachste Kotlin-Programm

Kotlin-Programme sind im Prinzip einfache Text-Dateien.
Damit sie von Kotlin verstanden werden, muss der Inhalt bestimmten Regeln folgen.
Diese wollen wir in den nächsten Wochen Schritt für Schritt kennen lernen.

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

## Eigene Funktionen definieren

Kotlin bietet viele vordefinierte Funktionen wie `println`,
die für verschiedenste Aufgaben in einem Programm genutzt werden.
Einige davon werden wir nach und nach kennen lernen.
Zunächst wollen wir uns aber ansehen, wie wir selbst eigene Funktionen definieren können,
und wie wir diese anschließend benutzen können.

_... Fortsetzung folgt!_ 