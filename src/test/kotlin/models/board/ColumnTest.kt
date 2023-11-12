package models.board

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError
import kotlin.test.assertEquals

class ColumnTest {
    @Test
    fun givenColumnThenLeftColumnsReturns() {
        assertEquals(
            Column.ONE.leftColumns(),
            emptyList()
        )
        assertEquals(
            Column.TWO.leftColumns(),
            listOf(Column.ONE)
        )
        assertEquals(
            Column.THREE.leftColumns(),
            listOf(Column.TWO, Column.ONE)
        )
        assertEquals(
            Column.FOUR.leftColumns(),
            listOf(Column.THREE, Column.TWO, Column.ONE)
        )
        assertEquals(
            Column.FIVE.leftColumns(),
            listOf(Column.FOUR, Column.THREE, Column.TWO, Column.ONE)
        )
        assertEquals(
            Column.SIX.leftColumns(),
            listOf(Column.FIVE, Column.FOUR, Column.THREE, Column.TWO, Column.ONE)
        )
        assertEquals(
            Column.SEVEN.leftColumns(),
            listOf(Column.SIX, Column.FIVE, Column.FOUR, Column.THREE, Column.TWO, Column.ONE)
        )
    }

    @Test
    fun givenColumnThenRightColumnsReturns() {
        assertEquals(
            Column.SEVEN.rightColumns(),
            emptyList()
        )
        assertEquals(
            Column.SIX.rightColumns(),
            listOf(Column.SEVEN)
        )
        assertEquals(
            Column.FIVE.rightColumns(),
            listOf(Column.SIX, Column.SEVEN)
        )
        assertEquals(
            Column.FOUR.rightColumns(),
            listOf(Column.FIVE, Column.SIX, Column.SEVEN)
        )
        assertEquals(
            Column.THREE.rightColumns(),
            listOf(Column.FOUR, Column.FIVE, Column.SIX, Column.SEVEN)
        )
        assertEquals(
            Column.TWO.rightColumns(),
            listOf(Column.THREE, Column.FOUR, Column.FIVE, Column.SIX, Column.SEVEN)
        )
        assertEquals(
            Column.ONE.rightColumns(),
            listOf(Column.TWO, Column.THREE, Column.FOUR, Column.FIVE, Column.SIX, Column.SEVEN)
        )
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
        assertThrows<AssertionError> { Column.build(8) }
    }
}