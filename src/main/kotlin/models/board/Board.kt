package models.board

import models.Color
import models.Movement
import models.board.line.LineChecker

class Board {
    private val holes: List<Hole> = createHoles()
    private var lastHole: Hole = holes.first()

    private fun createHoles(): List<Hole> {
        return Row.entries.flatMap { row: Row -> Column.entries.map { column: Column -> Hole(column, row) } }
    }

    fun getHoles(): List<Hole> {
        return holes
    }

    fun isValid(movement: Movement): Boolean {
        return firstEmptyHoleIn(movement.column) != null
    }

    private fun firstEmptyHoleIn(column: Column): Hole? {
        val columnHoles = holes.filter { hole: Hole -> hole.hasCol(column) }.sortedBy { hole: Hole -> hole.row }
        return columnHoles.firstOrNull { hole: Hole -> hole.hasNotToken() }
    }

    fun execute(movement: Movement) {
        assert(movement.color != Color.NULL)
        val column = movement.column
        val row = firstEmptyHoleIn(column)!!.row
        holes.first { hole: Hole -> hole.`is`(column, row) }.change(movement.color)
        lastHole = Hole(column, row, movement.color)
    }

    fun hasResult(): Boolean = LineChecker(holes, lastHole).hasLine()

    fun winner(): Color {
        return lastHole.color
    }
}
