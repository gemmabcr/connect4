package controllers.play

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.Session
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UndoControllerTest {
    private lateinit var session: Session
    private lateinit var undoController: UndoController

    @BeforeEach
    fun setUp() {
        session = mockk<Session>()
        undoController = UndoController(session)
    }


    @Test
    fun `given undo controller and execute when session undoable then call session undo`() {
        every { session.undoable() } returns true
        justRun { session.undo() }

        undoController.execute()

        verify { session.undo() }
    }

    @Test
    fun `given redo controller and execute when session is not redoable then not call session redo`() {
        every { session.undoable() } returns false

        undoController.execute()

        verify(exactly = 0) { session.undo() }
    }
}