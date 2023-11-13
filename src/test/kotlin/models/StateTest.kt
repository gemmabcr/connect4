package models

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StateTest {
    @Test
    fun whenCreatedStateValueReturnStart (){
        val state = State()
        assertEquals(state.getValue(), StateValue.START)
    }

    @Test
    fun whenStateIsStartAndNextThenStateValueReturnInGame (){
        val state = State()
        state.next()
        assertEquals(state.getValue(), StateValue.IN_GAME)
    }

    @Test
    fun whenStateIsInGameAndNextThenStateValueReturnResume (){
        val state = State()
        state.next()
        state.next()
        assertEquals(state.getValue(), StateValue.RESUME)
    }

    @Test
    fun whenStateIsResumeAndNextThenStateValueReturnExit (){
        val state = State()
        state.next()
        state.next()
        state.next()
        assertEquals(state.getValue(), StateValue.EXIT)
    }

    @Test
    fun whenStateIsExitAndNextThenStateValueReturnNull (){
        val state = State()
        state.next()
        state.next()
        state.next()
        state.next()
        assertEquals(state.getValue(), StateValue.EXIT)
    }
}