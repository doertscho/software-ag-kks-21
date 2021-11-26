package week7.ui

import javafx.application.Platform
import javafx.stage.Stage
import tornadofx.*
import week7.Player
import week7.State
import week7.Symbol
import week7.ai.SimpleAiPlayer
import week7.ai.WinningMoveAiPlayer
import week7.runGame

class TicTacToeUI : App(MainView::class) {

    private val stateContainer: StateContainer by inject()
    private val uiPlayer: UiPlayer by inject()

    override fun start(stage: Stage) {
        super.start(stage)

        val players: Map<Symbol, Player> = mapOf(
            Symbol.O to uiPlayer,
            Symbol.X to WinningMoveAiPlayer(),
        )

        Platform.runLater {
            runGame(stateContainer.state, players)
        }
    }
}

class StateContainer : Component(), ScopedInstance {
    val state = State()
}

fun main() {
    launch<TicTacToeUI>()
}
