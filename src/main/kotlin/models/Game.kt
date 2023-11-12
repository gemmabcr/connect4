package models

import models.board.Board
import models.player.Player

class Game {
    private var board: Board = Board()
    private var turn: Turn = Turn()

    fun getBoard(): Board = board
    fun winner(): Color = board.winner()
    fun hasResult() = board.hasResult()
    fun activePlayer(): Player = turn.getActivePlayer()
    fun activeColor(): Color = turn.getActiveColor()
    fun isValid(movement: Movement): Boolean = board.isValid(movement)
    fun execute(movement: Movement) {
        board.execute(movement)
        turn.next()
    }

    fun createMemento(): Memento {
        return Memento(this.board, this.turn)
    }

    fun setMemento(memento: Memento) {
        this.board = memento.getBoard()
        this.turn = memento.getTurn()
    }

    fun userPlayers(): Int = turn.userPlayers()
}
