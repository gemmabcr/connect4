package models.commands

import controllers.play.PlayController
import views.console.utils.Message

class ActionCommand(
    private val title: Message = Message.ACTION,
): Command(title) {
    override fun execute(playController: PlayController) {
        playController.action()
    }
}
