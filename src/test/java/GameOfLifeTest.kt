import org.junit.Assert.*
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.runner.Runner

@RunWith(JUnit4ClassRunner::class)
class GameOfLifeTest{

    val grid = Array(10){ IntArray(10) {0}}

    @Test
    fun `Any live cell with fewer than two live neighbors dies, as if caused by under population`(){

    }
}