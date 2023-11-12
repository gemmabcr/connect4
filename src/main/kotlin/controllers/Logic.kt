package controllers

import controllers.play.PlayController
import models.Session
import models.StateValue
import views.ViewFactory

class Logic(private val viewFactory: ViewFactory) {

    private val session: Session = Session()
    private val controllers: MutableMap<StateValue, Controller?> = mutableMapOf()

    init {
        controllers[StateValue.START] = StartController(session, viewFactory)
        controllers[StateValue.IN_GAME] = PlayController(session, viewFactory)
        controllers[StateValue.RESUME] = ResumeController(session, viewFactory)
        controllers[StateValue.EXIT] = null
    }

    private fun getController(): Controller? = controllers[session.getValueState()]
    fun execute() {
        var controller: Controller?
        do {
            controller = getController()
            controller?.execute()
        } while (controller != null)
    }
}
