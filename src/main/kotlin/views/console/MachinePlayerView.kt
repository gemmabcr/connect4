package views.console

import models.board.Column
import kotlin.random.Random

class MachinePlayerView {
    fun interact(): Column {
        val value: Int = Random.nextInt(1, 7)
        return Column.build(value)
    }
}
