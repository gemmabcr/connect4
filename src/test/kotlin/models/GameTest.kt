package models

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.board.Board
import models.game.GameForTesting
import models.player.PlayerTestBuilder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTest {
    private lateinit var gameForTesting: GameForTesting
    private lateinit var board: Board
    private lateinit var turn: Turn

    @BeforeEach
    fun setUp() {
        board = mockk<Board>()
        turn = mockk<Turn>()
        gameForTesting = GameForTesting(board, turn)
    }

    @Test
    fun `given game then winner return null`() {
        val game = Game()

        assertEquals(game.hasResult(), false)
        assertEquals(game.winner(), Color.NULL)
    }

    @Test
    fun `given game with board and turn when create memento then return memento with them`() {
        val game = Game()
        val memento = game.createMemento()

        assertEquals(memento.getBoard(), game.getBoard())
        assertEquals(memento.getTurn().getActivePlayer(), game.activePlayer())
    }

    @Test
    fun `given game with board when get board return that board`() {
        assertEquals(gameForTesting.getBoard(), board)
    }

    @Test
    fun `given game with turn when get turn return that turn`() {
        assertEquals(gameForTesting.getTurn(), turn)
    }

    @Test
    fun `given game when winner then return board winner`() {
        every { board.winner() } returns Color.RED

        assertEquals(gameForTesting.winner(), board.winner())
    }

    @Test
    fun `given game when has result then return board has result`() {
        every { board.hasResult() } returns false

        assertEquals(gameForTesting.hasResult(), board.hasResult())
    }

    @Test
    fun `given game when active player then return turn active player`() {
        every { turn.getActivePlayer() } returns PlayerTestBuilder.random()

        assertEquals(gameForTesting.activePlayer(), turn.getActivePlayer())
    }

    @Test
    fun `given game when active color then return turn active color`() {
        every { turn.getActiveColor() } returns Color.RED

        assertEquals(gameForTesting.activeColor(), turn.getActiveColor())
    }

    @Test
    fun `given game when user players then return turn user players`() {
        every { turn.userPlayers() } returns 2

        assertEquals(gameForTesting.userPlayers(), turn.userPlayers())
    }

    @Test
    fun `given game when is valid then return board is valid`() {
        val movement = mockk<Movement>()
        every { board.isValid(movement) } returns false

        assertEquals(gameForTesting.isValid(movement), board.isValid(movement))
    }

    @Test
    fun `given game when execute then call board execute and turn next`() {
        val movement = mockk<Movement>()
        justRun { board.execute(movement) }
        justRun { turn.next() }

        gameForTesting.execute(movement)

        verify { board.execute(movement) }
        verify { turn.next() }
    }

    @Test
    fun `given game when set memento then update board and turn`() {
        val memento = mockk<Memento>()
        every { memento.getBoard() } returns mockk<Board>()
        every { memento.getTurn() } returns mockk<Turn>()

        gameForTesting.setMemento(memento)

        assertEquals(gameForTesting.getBoard(), memento.getBoard())
        assertEquals(gameForTesting.getTurn(), memento.getTurn())
    }
}