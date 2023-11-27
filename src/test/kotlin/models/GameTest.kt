package models

import models.player.UserPlayer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GameTest {
    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    @Test
    fun `when created winner return null`() {
        assertEquals(game.hasResult(), false)
        assertEquals(game.winner(), Color.NULL)
    }

    @Test
    fun `when created active player is red user player`() {
        assertTrue(game.activePlayer() is UserPlayer)
        assertEquals(game.activeColor(), Color.RED)
    }
}