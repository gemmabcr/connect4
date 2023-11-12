package views.console

import views.console.utils.Message

class MenuView {
    private val title: Message = Message.MENU

    fun askOption(commandTitles: List<String>): Int {
        assert(commandTitles.isNotEmpty())
        if (commandTitles.size == 1) {
            return 0
        }
        var error = false
        var option: Int
        do {
            println()
            println(title)
            for (i in commandTitles.indices) {
                println("$i ) ${commandTitles[i]}")
            }
            option = readln().toInt();
            if (!includesValue(commandTitles.size, option)) {
                error = true;
            }
        } while (error)
        return option
    }

    private fun includesValue(max: Int, value: Int): Boolean {
        return value in 0..max;
    }
}
