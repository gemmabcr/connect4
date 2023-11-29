package controllers.play

import controllers.Controller
import models.Session
import models.menu.PlayMenu
import models.player.MachinePlayer
import models.player.UserPlayer
import views.ViewFactory

class PlayController(
    session: Session,
    private val viewFactory: ViewFactory,
) : Controller(session), PlayVisitor {

    private val actionController: ActionController = ActionController(session, viewFactory)
    private val undoController: UndoController = UndoController(session, viewFactory)
    private val redoController: RedoController = RedoController(session, viewFactory)

    override fun execute() {
        viewFactory.createBoardView().print(session.getBoard())
        viewFactory.createPlayView().turn(session.activeColor())
        session.activePlayer().accept(this)
        if (session.hasResult()) {
            nextState()
        }
    }

    override fun visit(userPlayer: UserPlayer) {
        PlayMenu(this, viewFactory).execute()
    }

    override fun visit(machinePlayer: MachinePlayer) {
        actionController.execute()
    }

    fun action() {
        actionController.execute()
    }
    fun undo() {
        undoController.execute()
    }
    fun redo() {
        redoController.execute()
    }

    fun undoable(): Boolean = session.undoable()
    fun redoable(): Boolean = session.redoable()
}
