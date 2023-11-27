package controllers

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.Color
import models.Session
import models.board.Board
import views.ViewFactory
import views.console.ResumeView
import kotlin.test.Test

class ResumeControllerTest {
    private val session = mockk<Session>()
    private val viewFactory = mockk<ViewFactory>()

    @Test
    fun `given resume controller when call execute then view factory create resume view is called`() {
        val resumeController = ResumeController(session, viewFactory)
        every { viewFactory.createResumeView() } returns ResumeView()
        justRun { viewFactory.createResumeView().result(any(), any()) }
        every { session.getBoard() } returns Board()
        every { session.winner() } returns Color.RED

        resumeController.execute()

        verify(exactly = 1) { viewFactory.createResumeView() }
        verify(exactly = 1) { viewFactory.createResumeView().result(any(), any()) }
    }
}