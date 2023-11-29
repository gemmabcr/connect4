package models.session

import models.*
import models.board.Board
import models.player.Player

class SessionForTesting(
    private val state: State,
    private val game: Game,
    private val registry: Registry
) {
    fun getBoard(): Board = game.getBoard()
    fun winner(): Color = game.winner()
    fun hasResult() = game.hasResult()
    fun activePlayer(): Player = game.activePlayer()
    fun activeColor(): Color = game.activeColor()
    fun isValid(movement: Movement): Boolean = game.isValid(movement)
    fun execute(movement: Movement) {
        game.execute(movement)
        registry.register()
    }
    fun nextState() {
        state.next()
    }
    fun undoable(): Boolean = registry.undoable()
    fun undo() {
        val userPlayers = game.userPlayers()
        registry.undo()
        if (userPlayers == 1) {
            registry.undo()
        }
    }
    fun redoable(): Boolean = registry.redoable()
    fun redo() {
        registry.redo()
    }
    fun getValueState(): StateValue = state.getValue()
}