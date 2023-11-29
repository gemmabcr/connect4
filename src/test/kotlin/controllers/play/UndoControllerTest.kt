package controllers.play

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.Session
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import views.ViewFactory

class UndoControllerTest {
    private lateinit var session: Session
    private lateinit var undoController: UndoController
    private lateinit var viewFactory: ViewFactory

    @BeforeEach
    fun setUp() {
        session = mockk<Session>()
        viewFactory = mockk<ViewFactory>()
        undoController = UndoController(session, viewFactory)
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
        justRun { viewFactory.createErrorView(any()).message() }

        undoController.execute()

        verify(exactly = 0) { session.undo() }
        verify(exactly = 1) { viewFactory.createErrorView(any()) }
    }
}