import org.junit.Before
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith

@RunWith(JUnit4ClassRunner::class)
class GameOfLifeTest {

    private val array = arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

    private lateinit var grid: Grid
    private lateinit var gameOfLife: GameOfLife

    @Before
    fun setUp() {
        grid = Grid(array)
        gameOfLife = GameOfLife()
    }

    @Test
    fun `Any live cell with fewer than two live neighbors dies, as if caused by under population`() {
        val gameOfLife = gameOfLife.killCellIfUnderPopulation(grid)

        val expected = arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        equals(expected, gameOfLife.grid)

    }

    @Test
    fun `Any live cell with two or three live neighbors lives on to the next generation`() {
        val gameOfLife = gameOfLife.keepCellAliveIfTwoOrThreeLiveNeighboursPresent(grid)

        val expected = arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        equals(expected, gameOfLife.grid)

    }

    @Test
    fun `Any live cell with more than three live neighbors dies, as if by overpopulation`() {
        val gameOfLife = gameOfLife.killCellIfOverPopulation(grid)

        val expected = arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        equals(expected, gameOfLife.grid)
    }

    @Test
    fun `Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction`() {
        val gameOfLife = gameOfLife.reproduceCellIfExactlyThreeLiveNeighbours(grid)

        val expected = arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 1, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 1, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 0, 1, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        equals(expected, gameOfLife.grid)
    }

    @Test
    fun `Apply all rules`() {
        val gameOfLife = gameOfLife.applyRules(grid)

        val expected = arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 1, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 1, 0, 1, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 1, 1, 1, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        equals(expected, gameOfLife.grid)
    }

    private fun equals(expected: Array<IntArray>, actual: Array<IntArray>) {
        expected.forEachIndexed { rowIndex, rowItem ->
            assert(rowItem contentEquals actual[rowIndex])
        }
    }
}