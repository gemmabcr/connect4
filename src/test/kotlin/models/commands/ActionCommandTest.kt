package models.commands

import controllers.play.PlayController
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class ActionCommandTest {
    @Test
    fun `given action command when execute then call play controller action`() {
        val actionCommand = ActionCommand()
        val playController = mockk<PlayController>()
        justRun { playController.action() }

        actionCommand.execute(playController)

        verify { playController.action() }
    }
}