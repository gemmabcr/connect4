package views.console

import models.board.Column
import models.player.MachinePlayer
import models.player.Player
import models.player.PlayerVisitor
import models.player.UserPlayer

class PlayerView: GameView(), PlayerVisitor {
    private val machinePlayerView : MachinePlayerView = MachinePlayerView()
    private val userPlayerView : UserPlayerView = UserPlayerView()

    fun interact(player: Player): Column {
        return player.accept(this)
    }

    override fun accept(player: MachinePlayer): Column {
        return machinePlayerView.interact()
    }

    override fun accept(player: UserPlayer): Column {
        return userPlayerView.interact()
    }
}
