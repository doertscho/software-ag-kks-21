package week7.ui

import javafx.beans.property.SimpleObjectProperty
import tornadofx.Component
import tornadofx.ScopedInstance
import tornadofx.awaitUntil
import week7.Move
import week7.Player
import week7.State

class UiPlayer : Player, Component(), ScopedInstance {

    private val clicked = SimpleObjectProperty<Move?>(null)

    fun click(rowNo: Int, columnNo: Int) {
        clicked.set(Move(rowNo, columnNo))
    }

    override fun nextMove(state: State): Move {
        clicked.awaitUntil { it != null }
        val nextMove = clicked.value ?: error("failed to retrieve click")
        clicked.set(null)
        return nextMove
    }
}
