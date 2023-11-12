package models

import models.board.Board

class Memento(
    private val board: Board,
    private val turn: Turn
) {
    fun getBoard(): Board = board
    fun getTurn(): Turn = turn
}
