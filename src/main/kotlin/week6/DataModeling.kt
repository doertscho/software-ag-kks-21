package week6

enum class Type {
    King,
    Queen,
    Bishop,
    Knight,
    Tower,
    Pawn,
}

enum class Colour {
    White,
    Black,
}

data class ChessFigure(
    val type: Type,
    val colour: Colour,
    val name: String = "",
    val age: Int = 0,
)

data class Position(
    val row: Int,
    val column: Int,
)

data class Move(
    val figure: ChessFigure,
    val source: Position,
    val target: Position,
)

// Selbst definierte Datentypen können ebenso Eingaben für Funktionen sein:
fun describeChessFigure(figure: ChessFigure) {
    println("Die Farbe der Figur ist: ${figure.colour}")
    println("Der Typ der Figur ist: ${figure.type}")
    println("Die Figur heißt: ${figure.name}")
}

fun main() {

    val blackKing = ChessFigure(Type.King, Colour.Black)

    // Der folgende Code erstellt uns ein zweidimensionales Array mit 8x8 Feldern,
    // die alle anfangs leer sind, also den null-Wert enthalten.
    val chessBoard: Array<Array<ChessFigure?>> = Array(8) {
        Array(8) {
            null
        }
    }

    // Die einzelnen Felder können wir nun gezielt mit "echten" Werten füllen:
    chessBoard[6][2] = ChessFigure(Type.Pawn, Colour.White)
    chessBoard[1][2] = ChessFigure(Type.Knight, Colour.White)
    chessBoard[2][5] = blackKing

    // So kann ich auf Bestandteile meines komplexen Datentyps zugreifen:
    val chessFigure = ChessFigure(Type.Queen, Colour.Black)
    println("Die Farbe der Figur ist: ${chessFigure.colour}")
    println("Der Typ der Figur ist: ${chessFigure.type}")
    // Ich kann diesen komplexen Wert auch als Ganzes an meine Funktion übergeben:
    describeChessFigure(chessFigure)

    // Wenn ein komplexer Wert wiederum komplexe Werte als Bestandteil enthält,
    // kann ich mehrere Zugriffe aneinanderreihen:
    val firstMove = Move(
        ChessFigure(Type.Pawn, Colour.White),
        Position(1, 5),
        Position(3, 5),
    )
    val targetRowOfFirstMove = firstMove.target.row
}
