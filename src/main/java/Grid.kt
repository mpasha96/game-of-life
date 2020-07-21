class Grid(val grid: Array<IntArray>) {

    fun getNeighbours(row: Int, col: Int): List<Int> {

        val list: MutableList<Int> = mutableListOf()

        if (col + 1 < grid[0].size) {
            list.add(grid[row][col + 1])
        }

        if (col + 1 < grid[0].size && row + 1 < grid.size) {
            list.add(grid[row + 1][col + 1])
        }

        if (row + 1 < grid.size) {
            list.add(grid[row + 1][col])
        }

        if (col - 1 >= 0 && row + 1 < grid.size) {
            list.add(grid[row + 1][col - 1])
        }

        if (col - 1 >= 0) {
            list.add(grid[row][col - 1])
        }

        if (col - 1 >= 0 && row - 1 >= 0) {
            list.add(grid[row - 1][col - 1])
        }

        if (row - 1 >= 0) {
            list.add(grid[row - 1][col])
        }

        if (col + 1 < grid[0].size && row - 1 >= 0) {
            list.add(grid[row - 1][col + 1])
        }

        return list

    }

    fun getLiveCells(row: Int, col: Int): Int {
        return getNeighbours(row, col).sum()
    }
}