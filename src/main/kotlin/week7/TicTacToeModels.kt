@file:Suppress("ArrayInDataClass")

package week7

enum class Symbol {
    X,
    O;

    fun other(): Symbol = if (this == X) O else X
}

data class Move(
        val row: Int,
        val column: Int
)

data class State(
        var nextPlayerSymbol: Symbol = Symbol.X,
        val field: Array<Array<Symbol?>> = arrayOf(
                arrayOf(null, null, null),
                arrayOf(null, null, null),
                arrayOf(null, null, null),
        )
)

interface Player {
    fun nextMove(state: State): Move
}
