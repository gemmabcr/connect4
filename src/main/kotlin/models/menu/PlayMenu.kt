package models.menu

import controllers.play.PlayController
import models.commands.ActionCommand
import models.commands.RedoCommand
import models.commands.UndoCommand
import views.ViewFactory

class PlayMenu(
    private val playController: PlayController,
    private val viewFactory: ViewFactory
): Menu(viewFactory) {
    init {
        this.addCommand(ActionCommand())
        if (playController.undoable()){
            this.addCommand(UndoCommand())
        }
        if (playController.redoable()) {
            this.addCommand(RedoCommand())
        }
    }

    fun execute() {
        askCommand().execute(playController)
    }
}
