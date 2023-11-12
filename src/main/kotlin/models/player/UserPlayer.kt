package models.player

import controllers.play.PlayControllerVisitor
import models.Color

class UserPlayer(color: Color): Player(color) {
    override fun accept(playerControllerVisitor: PlayControllerVisitor) {
        playerControllerVisitor.visit(this)
    }
}
