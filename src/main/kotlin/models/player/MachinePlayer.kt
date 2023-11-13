package models.player

import controllers.play.PlayControllerVisitor
import models.Color

data class MachinePlayer(private val color: Color) : Player(color) {
    override fun accept(playerControllerVisitor: PlayControllerVisitor) {
        playerControllerVisitor.visit(this)
    }
}
