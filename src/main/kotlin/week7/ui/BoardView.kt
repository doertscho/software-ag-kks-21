package week7.ui

import javafx.application.Platform
import javafx.beans.property.SimpleObjectProperty
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*
import week7.State
import week7.Symbol

class BoardView : View() {

    private val stateContainer: StateContainer by inject()
    private val state: State by lazy { stateContainer.state }

    private val uiPlayer: UiPlayer by inject()

    private val fields = Array(3) {
        Array(3) {
            SimpleObjectProperty<Symbol?>(null)
        }
    }

    override fun onDock() {
        super.onDock()
        println("onDock BoardView")
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
        fields.forEachIndexed { rowNo, fieldsRow ->
            fieldsRow.forEachIndexed { colNo, property ->
                property.set(state.field[rowNo][colNo])
            }
        }
    }

    override val root = gridpane {
        for ((rowNo, fieldsRow) in fields.withIndex()) {
            row {
                for ((colNo, field) in fieldsRow.withIndex()) {
                    add(square(rowNo, colNo, field))
                }
            }
        }
    }

    private fun getColour(symbol: Symbol?): Color = when (symbol) {
        Symbol.X -> Color.DARKBLUE
        Symbol.O -> Color.DARKRED
        else -> Color.BLACK
    }

    private fun opaque(color: Color) = Color(color.red, color.green, color.blue, 0.3)

    private fun square(rowNo: Int, columnNo: Int, field: SimpleObjectProperty<Symbol?>) = hbox {

        prefWidth = 150.0

        style {
            backgroundColor += Color.WHITE
            minWidth = Dimension(150.0, Dimension.LinearUnits.px)
            minHeight = Dimension(150.0, Dimension.LinearUnits.px)
            borderColor += box(all = Color.GRAY)
            borderWidth += box(all = Dimension(2.0, Dimension.LinearUnits.px))
        }

        onMouseEntered = EventHandler {
            if (field.value == null) {
                style(append = true) {
                    backgroundColor += opaque(getColour(state.nextPlayerSymbol))
                }
            }
        }

        onMouseExited = EventHandler {
            style(append = true) {
                backgroundColor += Paint.valueOf("#fff")
            }
        }

        onMouseClicked = EventHandler {
            if (field.value == null) {
                uiPlayer.click(rowNo, columnNo)
            }
        }

        label(field) {

            alignment = Pos.CENTER

            style {
                fontSize = Dimension(100.0, Dimension.LinearUnits.px)
                textFill = Color.BLACK
                minWidth = Dimension(150.0, Dimension.LinearUnits.px)
                minHeight = Dimension(150.0, Dimension.LinearUnits.px)
            }

            field.onChange { symbol ->
                style(append = true) {
                    textFill = getColour(symbol)
                }
            }
        }
    }
}