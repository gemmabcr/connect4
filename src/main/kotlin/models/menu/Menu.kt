package models.menu

import models.commands.Command
import views.console.MenuView

abstract class Menu {
    private val commandList: MutableList<Command> = mutableListOf()
    private var menuView: MenuView = MenuView()

    fun askCommand(): Command {
        return commandList[menuView.askOption(commandList.map { it.getTitle() })]
    }

    fun addCommand(command: Command) {
        commandList.add(command);
    }
}
