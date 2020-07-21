
import GameOfLife.Companion.applyRules
import GameOfLife.Companion.keepCellAliveIfTwoOrThreeLiveNeighboursPresent
import GameOfLife.Companion.killCellIfOverPopulation
import GameOfLife.Companion.killCellIfUnderPopulation
import GameOfLife.Companion.reproduceCellIfExactlyThreeLiveNeighbours
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

    private var grid = Grid(array)

    @Test
    fun `Any live cell with fewer than two live neighbors dies, as if caused by under population`() {

        val gameOfLife = killCellIfUnderPopulation(grid)

        var expected = arrayOf(
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
    fun `Any live cell with two or three live neighbors lives on to the next generation`(){

        val gameOfLife = keepCellAliveIfTwoOrThreeLiveNeighboursPresent(grid)

        var expected = arrayOf(
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
    fun `Any live cell with more than three live neighbors dies, as if by overpopulation`(){
        val gameOfLife = killCellIfOverPopulation(grid)

        var expected = arrayOf(
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
    fun `Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction`(){
        val gameOfLife = reproduceCellIfExactlyThreeLiveNeighbours(grid)

        var expected = arrayOf(
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
    fun `Apply all rules`(){
        val gameOfLife = applyRules(grid)

            var expected = arrayOf(
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