package models.board

import models.Color

class Hole(
    val column: Column,
    val row: Row,
    var color: Color = Color.NULL
) {
    fun hasCol(col: Column): Boolean {
        return column == col
    }

    fun hasRow(ro: Row): Boolean {
        return row == ro
    }

    fun hasNotToken(): Boolean {
        return color == Color.NULL
    }

    fun `is`(tokenColor: Color): Boolean {
        return color == tokenColor
    }

    fun `is`(col: Column, r: Row): Boolean {
        return column == col && row == r
    }

    fun isLastRow(): Boolean {
        return row == Row.last()
    }

    fun change(newColor: Color) {
        color = newColor
    }

    override fun toString(): String {
        return "HOLE -> Column: $column | Row: $row | Color: $color"
    }
}
