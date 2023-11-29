package models.commands

import controllers.play.PlayController
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class RedoCommandTest {
    @Test
    fun `given redo command when execute then call play controller redo`() {
        val redoCommand = RedoCommand()
        val playController = mockk<PlayController>()
        justRun { playController.redo() }

        redoCommand.execute(playController)

        verify { playController.redo() }
    }
}