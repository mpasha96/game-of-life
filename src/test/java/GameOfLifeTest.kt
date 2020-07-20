import GameOfLife.Companion.applyRule
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(JUnit4ClassRunner::class)
class GameOfLifeTest {

    var grid = arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))


    @Test
    fun `Any live cell with fewer than two live neighbors dies, as if caused by under population`() {

        val gameOfLife = applyRule(grid)

        var expected = arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        equals(expected, gameOfLife)

    }

    @Test
    fun `test get neighbours`() {
        val gameOfLife = GameOfLife()

        val actual = gameOfLife.getNeighbours(grid, 9, 0)


        assert(actual.isNotEmpty())

        assertEquals(listOf(0, 0, 0), actual)


    }

    private fun equals(expected: Array<IntArray>, actual: Array<IntArray>) {
        expected.forEachIndexed { rowIndex, rowItem ->
            assert(rowItem contentEquals actual[rowIndex])
        }
    }


}