package models.menu

import models.commands.Command
import views.ViewFactory

abstract class Menu(viewFactory: ViewFactory) {
    private val commandList: MutableList<Command> = mutableListOf()
    private val menuView = viewFactory.createMenuView()

    fun askCommand(): Command {
        return commandList[menuView.askOption(commandList.map { it.getTitle() })]
    }

    fun addCommand(command: Command) {
        commandList.add(command);
    }
}
