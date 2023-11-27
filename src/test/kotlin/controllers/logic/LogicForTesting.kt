package controllers.logic

import controllers.Controller
import controllers.ResumeController
import controllers.StartController
import controllers.play.PlayController
import models.Session
import models.StateValue
import views.ViewFactory
import views.console.ConsoleViewFactory

class LogicForTesting(private val session: Session) {
    private val viewFactory: ViewFactory = ConsoleViewFactory()
    private val controllers: MutableMap<StateValue, Controller?> = mutableMapOf()

    init {
        controllers[StateValue.START] = StartController(session, viewFactory)
        controllers[StateValue.IN_GAME] = PlayController(session, viewFactory)
        controllers[StateValue.RESUME] = ResumeController(session, viewFactory)
        controllers[StateValue.EXIT] = null
    }

    fun getController(): Controller? = controllers[session.getValueState()]
}
