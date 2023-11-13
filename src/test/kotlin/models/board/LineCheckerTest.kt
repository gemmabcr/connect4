package models.board

import models.Color
import models.board.line.LineChecker
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LineCheckerTest {
    private lateinit var holes: List<Hole>
    private lateinit var lastHole: Hole
    private lateinit var lineChecker: LineChecker

    @Test
    fun whenAllHolesAreColorNullThenHasLineReturnFalse() {
        holes = Column.entries.map { column: Column -> Hole(column, Row.FIRST)  }
        lastHole = Hole(Column.ONE, Row.FIRST)
        lineChecker = LineChecker(holes, lastHole)
        assertEquals(lineChecker.hasLine(), false)
    }

    @Test
    fun whenFourHolesAreSameColorButNotContiguousHasLineReturnFalse() {
        lastHole = Hole(Column.THREE, Row.FIRST, Color.RED)
        holes = listOf(
            Hole(Column.ONE, Row.FIRST, Color.RED),
            Hole(Column.TWO, Row.FIRST, Color.NULL),
            lastHole,
            Hole(Column.FOUR, Row.FIRST, Color.RED),
            Hole(Column.FIVE, Row.FIRST, Color.RED),
            Hole(Column.SIX, Row.FIRST, Color.NULL),
            Hole(Column.SEVEN, Row.FIRST, Color.NULL),
        )
        lineChecker = LineChecker(holes, lastHole)

        assertEquals(lineChecker.hasLine(), false)
    }

    @Test
    fun whenFourHolesAreSameColorAndHorizontalContiguousHasLineReturnTrue() {
        lastHole = Hole(Column.THREE, Row.FIRST, Color.RED)
        holes = BoardDummy.hasLineInFirstRow()
        lineChecker = LineChecker(holes, lastHole)
        assertEquals(lineChecker.hasLine(), true)
    }

    @Test
    fun whenFourHolesAreSameColorAndVerticalContiguousHasLineReturnTrue() {
        holes = BoardDummy.hasLineInFirstColumn()
        lastHole = holes.last { hole: Hole -> hole.`is`(Color.RED) }
        lineChecker = LineChecker(holes, lastHole)
        assertEquals(lineChecker.hasLine(), true)
    }
}