package models.player

import controllers.play.PlayVisitor
import models.Color
import models.board.Column

data class MachinePlayer(private val color: Color) : Player(color) {
    override fun accept(playVisitor: PlayVisitor) {
        playVisitor.visit(this)
    }

    override fun accept(visitor: PlayerVisitor): Column {
        return visitor.accept(this)
    }
}
