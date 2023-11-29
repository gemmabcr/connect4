package models.player

import controllers.play.PlayVisitor
import models.Color
import models.board.Column

abstract class Player(private val color: Color) {
    fun getColor(): Color = color
    abstract fun accept(visitor: PlayerVisitor): Column
    abstract fun accept(visitor: PlayVisitor)
}
