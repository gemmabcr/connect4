package controllers

import models.Session
import views.ViewFactory

class StartController(
    session: Session,
    private val viewFactory: ViewFactory
) : Controller(session) {
    override fun execute() {
        viewFactory.createStartView().welcome()
        nextState()
    }
}
