package controllers

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.Session
import views.ViewFactory
import views.console.StartView
import kotlin.test.Test

class StartControllerTest {
    private val session = mockk<Session>()
    private val viewFactory = mockk<ViewFactory>()

    @Test
    fun `given resume controller when call execute then view factory create resume view is called`() {
        val startController = StartController(session, viewFactory)
        every { viewFactory.createStartView() } returns StartView()
        justRun { viewFactory.createStartView().welcome() }
        justRun { session.nextState() }

        startController.execute()

        verify(exactly = 1) { viewFactory.createStartView() }
        verify(exactly = 1) { viewFactory.createStartView().welcome() }
    }
}