package controllers.play

import models.player.MachinePlayer
import models.player.UserPlayer

interface PlayVisitor {
    fun visit(userPlayer: UserPlayer)
    fun visit(machinePlayer: MachinePlayer)
}
