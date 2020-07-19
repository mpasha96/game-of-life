import GameOfLife.Companion.applyRule
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith


@RunWith(JUnit4ClassRunner::class)
class GameOfLifeTest{

    var grid = arrayOf(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))


    @Test
    fun `Any live cell with fewer than two live neighbors dies, as if caused by under population`(){

        val gameOfLife = GameOfLife.applyRule(grid)

    }


}