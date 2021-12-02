package week7.ai

import week7.*

// Diese KI ist etwas schlauer als der SimpleAiPlayer. Wenn es die Möglichkeit gibt, das Spiel im aktuellen Zug zu
// gewinnen, wird diese KI den entsprechenden Zug ausführen.
class WinningMoveAiPlayer : Player {

    override fun nextMove(state: State): Move {
        for (row in 0 .. 2) {
            for (column in 0 ..2) {
                if (isValidMove(state, Move(row, column))) {
                    if (isWinningMove(state, row, column)) {
                        return Move(row, column)
                    }
                }
            }
        }
        return SimpleAiPlayer().nextMove(state)
    }

    fun isWinningMove(state: State, row: Int, column: Int): Boolean {
        state.field[row][column] = state.nextPlayerSymbol
        val winner = winner(state)
        state.field[row][column] = null
        return winner == state.nextPlayerSymbol
    }
}
