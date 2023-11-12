package models.board

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError
import kotlin.test.assertEquals


class ColumnTest {
    @Test
    fun whenIsFirstColumnThenLeftColumnsReturnEmpty() {
        val column = Column.ONE
        assertEquals(column.leftColumns(), emptyList())
    }

    @Test
    fun whenIsLastColumnThenRightColumnsReturnEmpty() {
        val column = Column.SEVEN
        assertEquals(column.rightColumns(), emptyList())
    }

    @Test
    fun givenAnExistentIndexThenReturnColumnWithThatIndex() {
        assertEquals(Column.build(1), Column.ONE)
        assertEquals(Column.build(2), Column.TWO)
        assertEquals(Column.build(3), Column.THREE)
        assertEquals(Column.build(4), Column.FOUR)
        assertEquals(Column.build(5), Column.FIVE)
        assertEquals(Column.build(6), Column.SIX)
        assertEquals(Column.build(7), Column.SEVEN)
    }

    @Test
    fun givenAnNonexistentIndexToBuildThenReturnAnError() {
        assertThrows<AssertionError> { Column.build(0) }
    }
}