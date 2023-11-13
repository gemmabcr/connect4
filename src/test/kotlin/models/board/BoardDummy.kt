package models.board

import models.Color

object BoardDummy {
    fun hasLineInFirstColumn(): List<Hole> {
        return Column.entries.flatMap { column: Column ->
            if (column == Column.ONE) {
                listOf(
                    Hole(column, Row.FIRST, Color.NULL),
                    Hole(column, Row.SECOND, Color.RED),
                    Hole(column, Row.THIRD, Color.RED),
                    Hole(column, Row.FOURTH, Color.RED),
                    Hole(column, Row.FIFTH, Color.RED),
                    Hole(column, Row.SIXTH, Color.NULL),
                )
            } else {
                Row.entries.map { row -> Hole(column, row, Color.NULL) }
            }
        }
    }

    fun hasLineInFirstRow(): List<Hole> {
        return Row.entries.flatMap { row: Row ->
            if (row == Row.FIRST) {
                listOf(
                    Hole(Column.ONE, row, Color.NULL),
                    Hole(Column.TWO, row, Color.RED),
                    Hole(Column.THREE, row, Color.RED),
                    Hole(Column.FOUR, row, Color.RED),
                    Hole(Column.FIVE, row, Color.RED),
                    Hole(Column.SIX, row, Color.NULL),
                    Hole(Column.SEVEN, row, Color.NULL),
                )
            } else {
                Column.entries.map { column -> Hole(column, row, Color.NULL) }
            }
        }
    }
}