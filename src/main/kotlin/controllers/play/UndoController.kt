package controllers.play

import controllers.Controller
import models.Session
import views.console.ErrorView
import views.console.utils.ErrorMessage

class UndoController(
    session: Session
): Controller(session) {
    override fun execute() = when {
        session.undoable() -> session.undo()
        else -> ErrorView(ErrorMessage.NOT_UNDOABLE).message()
    }
}
