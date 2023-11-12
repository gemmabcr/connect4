package models.board

import models.Color
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class HoleTest {
    private val column = Column.FIVE
    private val row = Row.SECOND
    private lateinit var hole: Hole

    @BeforeEach
    fun setUp(){
        hole = Hole(column, row)
    }

    @Test
    fun givenHoleThen() {
        assertTrue(hole.hasCol(column))
        assertTrue(hole.hasRow(row))
        assertTrue(hole.hasNotToken())
        assertTrue(hole.`is`(Color.NULL))
        assertTrue(hole.`is`(column, row))
    }

    @Test
    fun givenColorToChangeThenColorIsUpdated() {
        val color = Color.RED

        hole.change(color)

        assertTrue(hole.`is`(color))
    }
}