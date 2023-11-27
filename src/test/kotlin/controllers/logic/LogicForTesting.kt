package controllers.logic

import controllers.Controller
import controllers.ResumeController
import controllers.StartController
import controllers.play.PlayController
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import models.Session
import models.StateValue

class LogicForTesting(private val session: Session) {
    private val controllers: MutableMap<StateValue, Controller?> = mutableMapOf()
    private val startController = mockk<StartController>()
    private val playController = mockk<PlayController>()
    private val resumeController = mockk<ResumeController>()

    init {
        controllers[StateValue.START] = startController
        controllers[StateValue.IN_GAME] = playController
        controllers[StateValue.RESUME] = resumeController
        controllers[StateValue.EXIT] = null
    }

    fun getController(): Controller? = controllers[session.getValueState()]

    fun execute() {
        every { session.getValueState() } returnsMany(listOf(StateValue.START, StateValue.IN_GAME, StateValue.RESUME, StateValue.EXIT))
        justRun { session.nextState() }
        every { startController.execute() } returns session.nextState()
        every { playController.execute() } returns session.nextState()
        every { resumeController.execute() } returns session.nextState()

        var controller: Controller?
        do {
            println(session.getValueState())
            controller = getController()
            controller?.execute()
        } while (controller != null)
    }
}
