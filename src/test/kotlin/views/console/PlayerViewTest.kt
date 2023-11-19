package views.console

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import models.board.Column
import models.player.MachinePlayer
import models.player.UserPlayer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PlayerViewTest {
    private lateinit var playerView: PlayerView
    private val userPlayerView = mockk<UserPlayerView>()
    private val machinePlayerView = mockk<MachinePlayerView>()
    private val userPlayer = mockk<UserPlayer>()
    private val machinePlayer = mockk<MachinePlayer>()

    @BeforeEach
    fun setUp() {
        playerView = PlayerView()
    }

    @Test
    fun `given user player when player view interact then interact with userplayer view`() {
        playerView.interact(userPlayer)
        every { userPlayerView.interact() } returns Column.ONE
        verify { userPlayerView.interact() }
        assertEquals(Column.ONE, playerView.interact(userPlayer))
    }

    @Test
    fun `given machine player when player view interact then interact with machine player view`() {
        playerView.interact(machinePlayer)
        every { machinePlayerView.interact() } returns Column.ONE
        verify { machinePlayerView.interact() }
        assertEquals(Column.ONE, playerView.interact(machinePlayer))
    }
}
