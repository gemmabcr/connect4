package views.console

import models.board.Column
import views.console.utils.ErrorMessage

class UserPlayerView {
    fun interact(): Column {
        var validValue: Boolean
        var value: Int
        do {
            value = chooseColumn()
            validValue = value in 1..7
            if (!validValue) {
                ErrorView(ErrorMessage.NONEXISTENT_COLUMN).message()
            }
        } while (!validValue)
        return Column.build(value)
    }

    private fun chooseColumn(): Int {
        println("Which hole do you want to put your token?")
        println("--- Write column: 1 to 7 ---")
        return readln().toInt()
    }
}
