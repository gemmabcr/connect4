package models.player

import models.Color

object PlayerTestBuilder {
    fun random(): Player = UserPlayer(Color.RED)
}