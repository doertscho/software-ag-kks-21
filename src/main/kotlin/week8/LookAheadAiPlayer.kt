package week8

import week7.*

class LookAheadAiPlayer : Player {

    override fun nextMove(state: State): Move {

        val winningMove = getWinningMove(state)
        if (winningMove != null) {
            return winningMove
        }

        val safeMove = getSafeMove(state)
        if (safeMove != null) {
            return safeMove
        }

        val validMove = getValidMove(state)
        if (validMove != null) {
            return validMove
        }

        val fallbackMove = getFallbackMove()
        return fallbackMove
    }

    fun getFallbackMove(): Move {
        return Move(0, 0)
    }

    fun getSafeMove(state: State): Move? {
        for (row in 0 .. 2) {
            for (column in 0 ..2) {
                if (isValidMove(state, Move(row, column))) {
                    if (isSafeMove(state, row, column)) {
                        return Move(row, column)
                    }
                }
            }
        }
        return null
    }

    fun isSafeMove(state: State, row: Int, column: Int): Boolean {
        state.field[row][column] = state.nextPlayerSymbol.other()
        val winner = winner(state)
        state.field[row][column] = null
        return winner == state.nextPlayerSymbol.other()
    }

    fun getValidMove(state: State): Move? {
        for (row in 0 .. 2) {
            for (column in 0 ..2) {
                if (isValidMove(state, Move(row, column))) {
                    return Move(row, column)
                }
            }
        }
        return null
    }

    fun getWinningMove(state: State): Move? {
        for (row in 0 .. 2) {
            for (column in 0 ..2) {
                if (isValidMove(state, Move(row, column))) {
                    if (isWinningMove(state, row, column)) {
                        return Move(row, column)
                    }
                }
            }
        }
        return null
    }

    fun isWinningMove(state: State, row: Int, column: Int): Boolean {
        state.field[row][column] = state.nextPlayerSymbol
        val winner = winner(state)
        state.field[row][column] = null
        return winner == state.nextPlayerSymbol
    }
}
