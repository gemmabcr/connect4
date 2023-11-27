package controllers.controller

import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.Session
import org.junit.jupiter.api.Test

class ControllerTest {
    private val session = mockk<Session>()
    private val controller = ControllerForTesting(session)

    @Test
    fun `given controller when next state is called then call session next state`() {
        justRun { session.nextState() }

        controller.nextState()

        verify(exactly = 1) { session.nextState() }
    }
}