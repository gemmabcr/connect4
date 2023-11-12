package models.board

import models.Color
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardTest {
    private lateinit var board: Board

    @BeforeEach
    fun before(){
        board = Board()
    }


    @Test
    fun whenCreatedReturn42HolesWithoutColor (){
        assertTrue(board.getHoles().all { it.`is`(Color.NULL) })
        assertEquals(board.getHoles().size, 42)
    }

    @Test
    fun whenCreatedWinnerReturnNull (){
        assertEquals(board.winner(), Color.NULL)
    }
}