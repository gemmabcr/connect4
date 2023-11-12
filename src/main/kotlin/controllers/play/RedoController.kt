package controllers.play

import controllers.Controller
import models.Session
import views.console.ErrorView
import views.console.utils.ErrorMessage

class RedoController(
    session: Session
): Controller(session) {
    override fun execute() = when {
        session.redoable() -> session.redo()
        else -> ErrorView(ErrorMessage.NOT_REDOABLE).message()
    }
}
