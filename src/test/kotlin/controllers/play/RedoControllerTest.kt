package controllers.play

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.Session
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RedoControllerTest {
    private lateinit var session: Session
    private lateinit var redoController: RedoController

    @BeforeEach
    fun setUp() {
        session = mockk<Session>()
        redoController = RedoController(session)
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

        redoController.execute()

        verify(exactly = 0) { session.redo() }
    }
}