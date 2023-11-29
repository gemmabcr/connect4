package models.session

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import models.*
import models.board.Column
import kotlin.test.Test
import kotlin.test.assertEquals

class SessionTest {
    private val state = State()
    private val game = Game()
    private val registry = Registry(game)
    private val session = SessionForTesting(state, game, registry)

    @Test
    fun `given session when get board then return game board`(){
        assertEquals(session.getBoard(), game.getBoard())
    }

    @Test
    fun `given session when winner then return game winner`(){
        assertEquals(session.winner(), game.winner())
    }

    @Test
    fun `given session when has result then return game has result`(){
        assertEquals(session.hasResult(), game.hasResult())
    }

    @Test
    fun `given session when active player then return game active player`(){
        assertEquals(session.activePlayer(), game.activePlayer())
    }

    @Test
    fun `given session when active color then return game active color`(){
        assertEquals(session.activeColor(), game.activeColor())
    }

    @Test
    fun `given session when is valid then return game is valid`(){
        val movement = Movement(Column.ONE, Color.RED)

        assertEquals(session.isValid(movement), game.isValid(movement))
    }

    @Test
    fun `given session when execute then call game execute and registry register`(){
        val gameMock = mockk<Game>()
        val registryMock = mockk<Registry>()
        val sessionWithMocks = SessionForTesting(state, gameMock, registryMock)
        val movement = Movement(Column.ONE, Color.RED)
        justRun { gameMock.execute(movement) }
        justRun { registryMock.register() }

        sessionWithMocks.execute(movement)

        verify { gameMock.execute(movement) }
        verify { registryMock.register() }
    }

    @Test
    fun `given session when next state then call state next`(){
        val stateMock = mockk<State>()
        val sessionWithMocks = SessionForTesting(stateMock, game, registry)
        justRun { stateMock.next() }

        sessionWithMocks.nextState()

        verify { stateMock.next() }
    }

    @Test
    fun `given session when undoable then return registry undoable`(){
        assertEquals(session.undoable(), registry.undoable())
    }

    @Test
    fun `given session and two user players when undo then call registry undo once`(){
        val gameMock = mockk<Game>()
        val registryMock = mockk<Registry>()
        val sessionWithMocks = SessionForTesting(state, gameMock, registryMock)
        every { gameMock.userPlayers() } returns 2
        justRun { registryMock.undo() }

        sessionWithMocks.undo()

        verify(exactly = 1) { registryMock.undo() }
    }

    @Test
    fun `given session and one user players when undo then call registry undo twice`(){
        val gameMock = mockk<Game>()
        val registryMock = mockk<Registry>()
        val sessionWithMocks = SessionForTesting(state, gameMock, registryMock)
        every { gameMock.userPlayers() } returns 1
        justRun { registryMock.undo() }

        sessionWithMocks.undo()

        verify(exactly = 2) { registryMock.undo() }
    }

    @Test
    fun `given session when redoable then return registry redoable`(){
        assertEquals(session.redoable(), registry.redoable())
    }

    @Test
    fun `given session when redo then call registry redo`(){
        val registryMock = mockk<Registry>()
        val sessionWithMocks = SessionForTesting(state, game, registryMock)
        justRun { registryMock.redo() }

        sessionWithMocks.redo()

        verify(exactly = 1) { registryMock.redo() }
    }

    @Test
    fun `given session when get value state then return state get value state`(){
        assertEquals(session.getValueState(), state.getValue())
    }
}