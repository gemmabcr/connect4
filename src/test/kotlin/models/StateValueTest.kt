package models

import kotlin.test.Test
import kotlin.test.assertEquals

class StateValueTest {
    @Test
    fun `given start state value when next then return in game`() {
        assertEquals(StateValue.next(StateValue.START), StateValue.IN_GAME)
    }

    @Test
    fun `given in game state value when next then return resume`() {
        assertEquals(StateValue.next(StateValue.IN_GAME), StateValue.RESUME)
    }

    @Test
    fun `given resume state value when next then return exit`() {
        assertEquals(StateValue.next(StateValue.RESUME), StateValue.EXIT)
    }

    @Test
    fun `given exit state value when next then return exit`() {
        assertEquals(StateValue.next(StateValue.EXIT), StateValue.EXIT)
    }
}