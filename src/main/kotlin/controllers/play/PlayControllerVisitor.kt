package controllers.play

import models.player.MachinePlayer
import models.player.UserPlayer

interface PlayControllerVisitor {
    fun visit(userPlayer: UserPlayer)
    fun visit(machinePlayer: MachinePlayer)
}
