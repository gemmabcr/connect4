package models.game

import models.Color
import models.Memento
import models.Movement
import models.Turn
import models.board.Board
import models.player.Player

class GameForTesting(
    private var board: Board,
    private var turn: Turn
) {
    fun getBoard(): Board = board
    fun getTurn(): Turn = turn
    fun winner(): Color = board.winner()
    fun hasResult() = board.hasResult()
    fun isValid(movement: Movement): Boolean = board.isValid(movement)
    fun activePlayer(): Player = turn.getActivePlayer()
    fun activeColor(): Color = turn.getActiveColor()
    fun userPlayers(): Int = turn.userPlayers()
    fun execute(movement: Movement) {
        board.execute(movement)
        turn.next()
    }
    fun setMemento(memento: Memento) {
        this.board = memento.getBoard()
        this.turn = memento.getTurn()
    }
}