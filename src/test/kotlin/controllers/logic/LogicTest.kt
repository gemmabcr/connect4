package controllers.logic

import controllers.ResumeController
import controllers.StartController
import controllers.play.PlayController
import models.Session
import models.StateValue
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LogicTest {
    private lateinit var logic: LogicForTesting
    private lateinit var session: Session

    @BeforeEach
    fun setup() {
        session = Session()
        logic = LogicForTesting(session)
    }

    @Test
    fun `given logic when state is start then get controller return start controller`() {
        assertEquals(session.getValueState(), StateValue.START)
        assertTrue(logic.getController() is StartController)
    }

    @Test
    fun `given logic when state is in game then get controller return play controller`() {
        session.nextState()
        assertEquals(session.getValueState(), StateValue.IN_GAME)
        assertTrue(logic.getController() is PlayController)
    }

    @Test
    fun `given logic when state is resume then get controller return resume controller`() {
        session.nextState()
        session.nextState()
        assertEquals(session.getValueState(), StateValue.RESUME)
        assertTrue(logic.getController() is ResumeController)
    }

    @Test
    fun `given logic when state is exit then get controller return null`() {
        session.nextState()
        session.nextState()
        session.nextState()
        assertEquals(session.getValueState(), StateValue.EXIT)
        assertEquals(logic.getController(), null)
    }
}