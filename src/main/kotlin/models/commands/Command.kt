package models.commands

import controllers.play.PlayController
import views.console.utils.Message

abstract class Command(
    private val title: Message,
) {
    abstract fun execute(playController: PlayController)
    fun getTitle(): String = this.title.message
}
