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

fun main() {

    val blackKing = ChessFigure(Type.King, Colour.Black)

    val chessBoard: Array<Array<ChessFigure?>> = Array(8) {
        Array(8) {
            null
        }
    }

    chessBoard[6][2] = ChessFigure(Type.Pawn, Colour.White)
    chessBoard[1][2] = ChessFigure(Type.Knight, Colour.White)
    chessBoard[2][5] = blackKing

    val chessFigure = ChessFigure(Type.Queen, Colour.Black)
    println("Die Farbe der Figur ist: ${chessFigure.colour}")
    println("Der Typ der Figur ist: ${chessFigure.type}")

    val firstMove = Move(
        ChessFigure(Type.Pawn, Colour.White),
        Position(1, 5),
        Position(3, 5),
    )

    firstMove.target.row
}
