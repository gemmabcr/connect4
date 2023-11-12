package models.board

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RowTest {
    @Test
    fun givenFirstRowThenDownRowsReturnEmpty() {
        val firstRow = Row.FIRST
        assertEquals(firstRow.downRows(), emptyList())
    }

    @Test
    fun givenLastRowThenUpRowsReturnEmpty() {
        val lastRow = Row.SIXTH
        assertEquals(lastRow.upRows(), emptyList())
    }

    @Test
    fun lastReturnRowSixth() {
        assertEquals(Row.last(), Row.SIXTH)
    }
}