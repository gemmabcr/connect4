package models

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StateTest {
    @Test
    fun `when created state value return start` (){
        val state = State()
        assertEquals(state.getValue(), StateValue.START)
    }

    @Test
    fun `when state is start and next then state value return in game` (){
        val state = State()
        state.next()
        assertEquals(state.getValue(), StateValue.IN_GAME)
    }

    @Test
    fun `when state is in game and next then state value return resume` (){
        val state = State()
        state.next()
        state.next()
        assertEquals(state.getValue(), StateValue.RESUME)
    }

    @Test
    fun `when state is resume and next then state value return exit` (){
        val state = State()
        state.next()
        state.next()
        state.next()
        assertEquals(state.getValue(), StateValue.EXIT)
    }

    @Test
    fun `when state is exit and next then state value return null` (){
        val state = State()
        state.next()
        state.next()
        state.next()
        state.next()
        assertEquals(state.getValue(), StateValue.EXIT)
    }
}