package controllers.play

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.Session
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import views.ViewFactory

class RedoControllerTest {
    private lateinit var session: Session
    private lateinit var redoController: RedoController
    private lateinit var viewFactory: ViewFactory

    @BeforeEach
    fun setUp() {
        session = mockk<Session>()
        viewFactory = mockk<ViewFactory>()
        redoController = RedoController(session, viewFactory)
    }

    @Test
    fun `given redo controller and execute when session redoable then call session redo`() {
        every { session.redoable() } returns true
        justRun { session.redo() }

        redoController.execute()

        verify { session.redo() }
    }

    @Test
    fun `given redo controller and execute when session is not redoable then not call session redo`() {
        every { session.redoable() } returns false
        justRun { viewFactory.createErrorView(any()).message() }

        redoController.execute()

        verify(exactly = 0) { session.redo() }
        verify(exactly = 1) { viewFactory.createErrorView(any()) }
    }
}