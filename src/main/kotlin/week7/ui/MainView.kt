package week7.ui

import tornadofx.*

class MainView : View() {

    override val root = vbox {
        add<BoardView>()
        add<StatusInfoView>()
    }
}