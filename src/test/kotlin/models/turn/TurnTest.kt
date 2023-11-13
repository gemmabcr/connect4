package models.turn

import models.Color
import models.Turn
import models.player.MachinePlayer
import models.player.UserPlayer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TurnTest {

    private lateinit var turn: Turn

    @BeforeEach
    fun setUp() {
        turn = Turn()
    }

    @Test
    fun `given turn when game is not started then first player should be user player`() {
        assertEquals(UserPlayer(Color.RED), turn.getActivePlayer())
    }

    @Test
    fun `given turn when game has started and next turn then active player should be machine player`() {
        turn.next()
        assertEquals(MachinePlayer(Color.YELLOW), turn.getActivePlayer())
    }
}
