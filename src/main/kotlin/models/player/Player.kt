package models.player

import controllers.play.AcceptorPlayController
import models.Color

abstract class Player(private val color: Color): AcceptorPlayController {
    fun getColor(): Color = color
}
