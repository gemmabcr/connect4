package models

import models.player.MachinePlayer
import models.player.UserPlayer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TurnTest {
    private lateinit var turn: Turn

    @BeforeEach
    fun setUp() {
        turn = Turn()
    }

    @Test
    fun `when created active player return red user player` (){
        assertTrue(turn.getActivePlayer() is UserPlayer)
        assertEquals(turn.getActiveColor(), Color.RED)
    }

    @Test
    fun `next player return yellow machine player` (){
        turn.next()
        assertTrue(turn.getActivePlayer() is MachinePlayer)
        assertEquals(turn.getActiveColor(), Color.YELLOW)
    }

    @Test
    fun `when created user players return 1` (){
        assertEquals(turn.userPlayers(), 1)
    }
}