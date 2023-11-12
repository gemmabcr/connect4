package views.console

import models.Color
import models.board.Board
import views.console.utils.UiColorIcon

class ResumeView : GameView() {
    fun result(board: Board, winner: Color) {
        BoardView().print(board)
        println()
        println("${UiColorIcon(winner).icon()} PLAYER IS THE WINNER")
        linesLine()
    }
}
