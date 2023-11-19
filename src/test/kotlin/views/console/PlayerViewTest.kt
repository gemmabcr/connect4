package views.console

import io.mockk.mockk
import io.mockk.verify
import models.player.MachinePlayer
import models.player.UserPlayer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlayerViewTest {
    lateinit var playerView: PlayerView
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
        verify(exactly = 1) { userPlayerView.interact() }
    }

    @Test
    fun `given machine player when player view interact then interact with machine player view`() {
        playerView.interact(machinePlayer)
        verify(exactly = 1) { machinePlayerView.interact() }
    }
}