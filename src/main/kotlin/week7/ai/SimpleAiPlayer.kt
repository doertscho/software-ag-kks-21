package week7.ai

import week7.Move
import week7.Player
import week7.State
import week7.isValidMove

class SimpleAiPlayer : Player {

    override fun nextMove(state: State): Move {
        for (row in 0 .. 2) {
            for (column in 0 ..2) {
                if (isValidMove(state, Move(row, column))) {
                    return Move(row, column)
                }
            }
        }
        error("impossible situation detected!")
    }
}
