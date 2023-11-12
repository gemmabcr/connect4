package views.console

import models.Color
import views.console.utils.UiColorIcon

class PlayView : GameView() {
    fun turn(color: Color) {
        println()
        println("${UiColorIcon(color).icon()} PLAYER TURN")
        println()
    }
}
