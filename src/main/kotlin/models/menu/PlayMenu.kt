package models.menu

import controllers.play.PlayController
import models.commands.ActionCommand
import models.commands.RedoCommand
import models.commands.UndoCommand

class PlayMenu(private val playController: PlayController): Menu() {
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
