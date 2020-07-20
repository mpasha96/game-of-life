import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith

@RunWith(JUnit4ClassRunner::class)
class GridTest {

    var grid = Grid()


    @Test
    fun `test get neighbours bottom right`() {

        val actual = grid.getNeighbours(9, 9)

        assert(actual.isNotEmpty())

        assertEquals(listOf(0, 0, 0), actual)

    }

    @Test
    fun `test get neighbours bottom left`() {

        val actual = grid.getNeighbours(9, 0)

        assert(actual.isNotEmpty())

        assertEquals(listOf(0, 0, 0), actual)

    }

    @Test
    fun `test get neighbours top right`() {

        val actual = grid.getNeighbours(0, 9)

        assert(actual.isNotEmpty())

        assertEquals(listOf(0, 0, 0), actual)

    }

    @Test
    fun `test get neighbours top left`() {

        val actual = grid.getNeighbours(0, 0)

        assert(actual.isNotEmpty())

        assertEquals(listOf(0, 0, 0), actual)

    }


    @Test
    fun `test get live cells are zero`() {

        val actual = grid.getLiveCells(0, 0)

        assert(actual == 0)

    }

    @Test
    fun `test get live cells are two`() {

        val actual = grid.getLiveCells(5, 4)

        assert(actual == 2)

    }
}