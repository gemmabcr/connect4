package controllers.play

import controllers.Controller
import models.Movement
import models.Session
import models.player.Player
import views.ViewFactory
import views.console.utils.ErrorMessage

class ActionController(
    session: Session,
    private val viewFactory: ViewFactory
) : Controller(session) {
    override fun execute() {
        var movement: Movement
        do {
            val player: Player = session.activePlayer()
            movement = Movement(viewFactory.createPlayerView().interact(player), session.activeColor())
            val isValid = session.isValid(movement)
            if (!isValid) {
                viewFactory.createErrorView(ErrorMessage.PLENTY_COLUMN).message()
            }
        } while (!isValid)
        session.execute(movement)
    }
}
