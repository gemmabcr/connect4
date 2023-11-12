package models.commands

import controllers.play.PlayController
import views.console.utils.Message

class RedoCommand(
    private val title: Message = Message.REDO,
): Command(title) {
    override fun execute(playController: PlayController) {
        playController.redo()
    }
}
