package controllers.play

import controllers.Controller
import models.Session
import views.ViewFactory
import views.console.utils.ErrorMessage

class RedoController(
    session: Session,
    private val viewFactory: ViewFactory
): Controller(session) {
    override fun execute() = when {
        session.redoable() -> session.redo()
        else -> viewFactory.createErrorView(ErrorMessage.NOT_REDOABLE).message()
    }
}
