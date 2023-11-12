package models.board

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RowTest {
    @Test
    fun givenRowThenDownRowsReturns() {
        assertEquals(
            Row.FIRST.downRows(),
            emptyList()
        )
        assertEquals(
            Row.SECOND.downRows(),
            listOf(Row.FIRST)
        )
        assertEquals(
            Row.THIRD.downRows(),
            listOf(Row.SECOND, Row.FIRST)
        )
        assertEquals(
            Row.FOURTH.downRows(),
            listOf(Row.THIRD, Row.SECOND, Row.FIRST)
        )
        assertEquals(
            Row.FIFTH.downRows(),
            listOf(Row.FOURTH, Row.THIRD, Row.SECOND, Row.FIRST)
        )
        assertEquals(
            Row.SIXTH.downRows(),
            listOf(Row.FIFTH, Row.FOURTH, Row.THIRD, Row.SECOND, Row.FIRST)
        )
    }

    @Test
    fun givenRowThenUpRowsReturns() {
        assertEquals(
            Row.SIXTH.upRows(),
            emptyList()
        )
        assertEquals(
            Row.FIFTH.upRows(),
            listOf(Row.SIXTH)
        )
        assertEquals(
            Row.FOURTH.upRows(),
            listOf(Row.FIFTH, Row.SIXTH)
        )
        assertEquals(
            Row.THIRD.upRows(),
            listOf(Row.FOURTH, Row.FIFTH, Row.SIXTH)
        )
        assertEquals(
            Row.SECOND.upRows(),
            listOf(Row.THIRD, Row.FOURTH, Row.FIFTH, Row.SIXTH)
        )
        assertEquals(
            Row.FIRST.upRows(),
            listOf(Row.SECOND, Row.THIRD, Row.FOURTH, Row.FIFTH, Row.SIXTH)
        )
    }

    @Test
    fun lastReturnRowSixth() {
        assertEquals(Row.last(), Row.SIXTH)
    }
}