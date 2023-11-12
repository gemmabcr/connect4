package controllers

import models.Session
import views.ViewFactory

class ResumeController(
    session: Session,
    private val viewFactory: ViewFactory
) : Controller(session) {
    override fun execute() {
        viewFactory.createResumeView().result(session.getBoard(), session.winner())
    }
}
