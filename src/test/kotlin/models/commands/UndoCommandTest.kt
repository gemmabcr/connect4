package models.commands

import controllers.play.PlayController
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class UndoCommandTest {
    @Test
    fun `given undo command when execute then call play controller undo`() {
        val undoCommand = UndoCommand()
        val playController = mockk<PlayController>()
        justRun { playController.undo() }

        undoCommand.execute(playController)

        verify { playController.undo() }
    }
}