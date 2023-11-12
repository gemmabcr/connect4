package models

import models.player.MachinePlayer
import models.player.Player
import models.player.UserPlayer

class Turn {
    private val players: List<Player> = listOf(UserPlayer(Color.RED), MachinePlayer(Color.YELLOW))
    private var activePlayer: Player = firstPlayer()

    private fun firstPlayer(): Player = players[0]
    fun getActivePlayer(): Player = activePlayer
    fun getActiveColor(): Color = activePlayer.getColor()
    fun next() {
        activePlayer = players.first { it !== activePlayer }
    }

    fun userPlayers(): Int = players.filterIsInstance<UserPlayer>().size
}
