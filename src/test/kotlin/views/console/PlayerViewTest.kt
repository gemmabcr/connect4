package views.console

import io.mockk.every
import io.mockk.mockk
import models.board.Column
import models.player.Player
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PlayerViewTest {
    private lateinit var playerView: PlayerView
    @BeforeEach
    fun setUp() {
        playerView = PlayerView()
    }

    @Test
    fun `given player when player view interact then return column`() {
        val player = mockk<Player>()
        every { player.accept(playerView) } returns Column.ONE

        assertEquals(Column.ONE, playerView.interact(player))
    }
}
