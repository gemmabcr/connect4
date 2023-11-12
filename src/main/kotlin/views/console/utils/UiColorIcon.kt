package views.console.utils

import models.Color

class UiColorIcon(private val color: Color) {
    fun icon(): String = when (color) {
        Color.RED -> "\uD83D\uDD34"
        Color.YELLOW -> "\uD83D\uDFE1"
        else -> "⚪\uFE0F"
    }
}
