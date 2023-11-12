package views.console

import models.board.Column
import models.player.MachinePlayer
import models.player.Player
import models.player.UserPlayer

class PlayerView: GameView() {
    private val machinePlayerView : MachinePlayerView = MachinePlayerView()
    private val userPlayerView : UserPlayerView = UserPlayerView()

    fun interact(player: Player): Column {
        if (player is MachinePlayer) {
            return machinePlayerView.interact()
        }
        if (player is UserPlayer) {
            return userPlayerView.interact()
        }
        throw Error("undefined player type")
    }
}
