package models.commands

import controllers.play.PlayController
import views.console.utils.Message

class UndoCommand(
    private val title: Message = Message.UNDO,
): Command(title) {
    override fun execute(playController: PlayController) {
        playController.undo()
    }
}
