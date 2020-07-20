class GameOfLife {


    companion object {

        fun applyRule(grid: Array<IntArray>): Array<IntArray> {

            grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, colItem ->
                    {
                        applyUnderPopulationRule(grid, rowIndex, colIndex)
                    }
                }
            }

            return grid
        }

        private fun applyUnderPopulationRule(grid: Array<IntArray>, rowIndex: Int, colIndex: Int) {

        }

    }


    fun getNeighbours(grid: Array<IntArray>, row: Int, col: Int): List<Int> {

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
}