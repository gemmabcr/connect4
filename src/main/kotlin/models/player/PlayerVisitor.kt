package models.player

import models.board.Column

interface PlayerVisitor {
    fun accept(player: MachinePlayer): Column
    fun accept(player: UserPlayer): Column
}
