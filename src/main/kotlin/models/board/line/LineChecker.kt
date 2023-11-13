package models.board.line

import models.Color
import models.board.Column
import models.board.Hole
import models.board.Row

class LineChecker(private val holes: List<Hole>, private val lastHole: Hole) {
    private val requiredLineHoles: Int = 4

    fun hasLine(): Boolean {
        if (lastHole.`is`(Color.NULL)) {
            return false
        }
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
        val teammatesHoles = getContiguousHoles(direction).filter { it.`is`(lastHole.color) }
        return onlyContiguous(teammatesHoles, direction)
    }

    private fun onlyContiguous(teammatesHoles: List<Hole>, direction: Direction): List<Hole> {
        val indexes: List <Int> = if (direction == Direction.HORIZONTAL) teammatesHoles.map { hole -> hole.column.ordinal } else teammatesHoles.map { hole -> hole.row.ordinal }
        val contiguousHoles: MutableSet<Hole> = mutableSetOf()
        var index = 0
        while (index < indexes.size -2) {
            if (indexes[index+2] - indexes[index] == 2) {
                contiguousHoles.add(teammatesHoles[index+2])
                contiguousHoles.add(teammatesHoles[index+1])
                contiguousHoles.add(teammatesHoles[index])
            }
            index++
        }
        return contiguousHoles.toList()
    }

    private fun getContiguousHoles(direction: Direction): List<Hole> {
        if (direction == Direction.HORIZONTAL) {
            val columnsList: MutableSet<Column> = mutableSetOf()
            maxContiguousHoles(lastHole.column.leftColumns()).forEach { columnsList.add(it) }
            maxContiguousHoles(lastHole.column.rightColumns()).forEach { columnsList.add(it) }
            columnsList.add(lastHole.column)
            return columnsList.sorted().map { column: Column -> holes.find { hole: Hole -> hole.`is`(column, lastHole.row) }!!  }
        }
        if (direction == Direction.VERTICAL) {
            val rowsList: MutableList<Row> = maxContiguousHoles(lastHole.row.downRows())
            rowsList.add(lastHole.row)
            return rowsList.sorted().map { row: Row -> holes.find { hole: Hole -> hole.`is`(lastHole.column, row) }!!  }
        }
        return emptyList()
    }

    private fun <T>maxContiguousHoles(
        directionEntities: List<T>
    ): MutableList<T> {
        val maxArraySize = if (directionEntities.size >= requiredLineHoles) requiredLineHoles - 1 else directionEntities.size
        val entitiesList: MutableList<T> = mutableListOf()
        for (i in 0..< maxArraySize) {
            entitiesList.add(directionEntities[i])
        }
        return entitiesList
    }

    private fun isLine(holes: List<Hole>): Boolean {
        if (holes.size >= requiredLineHoles) {
            val color = lastHole.color
            for (i in 0..< holes.size - 3) {
                val line = holes.subList(i, i + 3)
                return line.all { it.color == color }
            }
        }
        return false
    }
}
