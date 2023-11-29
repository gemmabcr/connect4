package controllers.play

import controllers.Controller
import models.Session
import views.ViewFactory
import views.console.utils.ErrorMessage

class UndoController(
    session: Session,
    private val viewFactory: ViewFactory
): Controller(session) {
    override fun execute() = when {
        session.undoable() -> session.undo()
        else -> viewFactory.createErrorView(ErrorMessage.NOT_UNDOABLE).message()
    }
}
