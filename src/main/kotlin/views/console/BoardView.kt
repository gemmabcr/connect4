package views.console

import models.board.Board
import models.board.Column
import models.board.Hole
import models.board.Row
import views.console.utils.UiColorIcon

class BoardView: GameView() {
    private fun printColumnValues() {
        return Column.entries.forEach { column ->
            print("""  ${Column.entries[column.ordinal].ordinal + 1} """)
        }
    }

    fun print(board: Board) {
        println()
        linesLine()
        val holes = board.getHoles()
        printColumnValues()
        println()
        val descendentRows = Row.entries.sortedByDescending { it }
        descendentRows.forEach { row: Row ->
            holes.filter { hole: Hole -> hole.hasRow(row) }
                .sortedBy { it.column }
                .forEach{
                    val icon = UiColorIcon(it.color).icon()
                    print(""" $icon """)
                }
            println()
        }
        printColumnValues()
        println()
    }
}
