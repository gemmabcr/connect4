package controllers.play

import controllers.Controller
import models.Movement
import models.Session
import models.player.Player
import views.console.ErrorView
import views.console.PlayerView
import views.console.utils.ErrorMessage

class ActionController(
    session: Session
) : Controller(session) {
    override fun execute() {
        var movement: Movement
        do {
            val player: Player = session.activePlayer()
            movement = Movement(PlayerView().interact(player), session.activeColor())
            val isValid = session.isValid(movement)
            if (!isValid) {
                ErrorView(ErrorMessage.PLENTY_COLUMN).message()
            }
        } while (!isValid)
        session.execute(movement)
    }
}
