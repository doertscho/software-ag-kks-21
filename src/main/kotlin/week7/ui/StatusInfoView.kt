package week7.ui

import javafx.application.Platform
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.paint.Color
import tornadofx.*
import week7.State
import week7.validMoveIsPossible
import week7.winner

class StatusInfoView : View() {

    private val stateContainer: StateContainer by inject()
    private val state: State by lazy { stateContainer.state }

    private val property = SimpleObjectProperty<String>()

    override fun onDock() {
        super.onDock()
        println("onDock StatusInfoView")
        startSyncLoop()
    }

    private fun startSyncLoop() {
        Thread {
            Platform.runLater {
                syncState()
            }
            Thread.sleep(200)
            startSyncLoop()
        }.start()
    }

    private fun syncState() {
        val winner = winner(state)
        if (winner != null) {
            property.set("$winner gewinnt das Spiel!")
            return
        }

        if (!validMoveIsPossible(state)) {
            property.set("Das Spiel endet unentschieden!")
            return
        }

        property.set("${state.nextPlayerSymbol} ist an der Reihe.")
    }

    override val root = hbox {

        style {
            backgroundColor += Color.WHITE
            borderColor += box(all = Color.GRAY)
            borderWidth += box(all = Dimension(2.0, Dimension.LinearUnits.px))
            padding = box(all = Dimension(10.0, Dimension.LinearUnits.px))
        }

        label(property) {
            style {
                fontSize = Dimension(30.0, Dimension.LinearUnits.px)
            }
        }
    }
}