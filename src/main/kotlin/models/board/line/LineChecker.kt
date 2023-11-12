package models.board.line

import models.board.Column
import models.board.Hole
import models.board.Row

class LineChecker(private val holes: List<Hole>, private val lastHole: Hole) {
    private val requiredLineHoles: Int = 4

    fun hasLine(): Boolean {
        val teamTokens = holes.filter { it.`is`(lastHole.color) }
        if (teamTokens.size < requiredLineHoles) {
            return false
        }
        val horizontalHoles = getContiguousTeammates(Direction.HORIZONTAL)
        val verticalHoles = getContiguousTeammates(Direction.VERTICAL)
        return (isLine(horizontalHoles) || isLine(verticalHoles))
        // TODO: check in diagonal
    }

    private fun getContiguousTeammates(direction: Direction): List<Hole> {
        return getContiguousHoles(direction).filter { it.`is`(lastHole.color) }
    }

    private fun getContiguousHoles(direction: Direction): List<Hole> {
        if (direction == Direction.HORIZONTAL) {
            val columnsList: MutableSet<Column> = mutableSetOf()
            maxContiguousHoles(lastHole.column.leftColumns()).forEach { columnsList.add(it) }
            maxContiguousHoles(lastHole.column.rightColumns()).forEach { columnsList.add(it) }
            return columnsList.map { column: Column -> holes.find { hole: Hole -> hole.`is`(column, lastHole.row) }!!  }
        }
        if (direction == Direction.VERTICAL) {
            val rowsList: MutableList<Row> = maxContiguousHoles(lastHole.row.downRows())
            return rowsList.map { row: Row -> holes.find { hole: Hole -> hole.`is`(lastHole.column, row) }!!  }
        }
        return emptyList()
    }

    private fun <T>maxContiguousHoles(
        directionEntities: List<T>
    ): MutableList<T> {
        val maxArraySize = if (directionEntities.size > requiredLineHoles) requiredLineHoles else directionEntities.size
        val entitiesList: MutableList<T> = mutableListOf()
        for (i in 0 until maxArraySize) {
            entitiesList.add(directionEntities[i])
        }
        return entitiesList
    }

    private fun isLine(holes: List<Hole>): Boolean {
        if (holes.size >= requiredLineHoles) {
            val color = lastHole.color
            for (i in 0 until holes.size - 3) {
                val line = holes.subList(i, i + 3)
                return line.all { it.color == color }
            }
        }
        return false
    }
}
