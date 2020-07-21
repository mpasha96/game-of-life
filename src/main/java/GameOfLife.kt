private const val MAX_POPULATION_LIMIT = 3
private const val MIN_POPULATION_LIMIT = 2
private const val ALIVE = 1
private const val DEAD = 0

class GameOfLife {

    companion object {

        fun applyRules(grid: Grid): Grid {
            killCellIfUnderPopulation(grid)
            keepCellAliveIfTwoOrThreeLiveNeighboursPresent(grid)
            killCellIfOverPopulation(grid)
            reproduceCellIfExactlyThreeLiveNeighbours(grid)

            return grid
        }

        fun killCellIfUnderPopulation(grid: Grid): Grid {
            iterateGrid(grid) { rowIndex, colIndex ->
                if (isCellAlive(grid, rowIndex, colIndex) && isUnderPopulated(grid, rowIndex, colIndex)) {
                    killCell(grid, rowIndex, colIndex)
                }
            }
            return grid
        }

        fun keepCellAliveIfTwoOrThreeLiveNeighboursPresent(grid: Grid): Grid {
            return grid // as if we dont need to change anything here
        }

        fun killCellIfOverPopulation(grid: Grid): Grid {
            iterateGrid(grid) { rowIndex, colIndex ->
                if (isCellAlive(grid, rowIndex, colIndex) && isOverPopulated(grid, rowIndex, colIndex)) {
                    killCell(grid, rowIndex, colIndex)
                }
            }
            return grid
        }

        fun reproduceCellIfExactlyThreeLiveNeighbours(grid: Grid): Grid {
            iterateGrid(grid) { rowIndex, colIndex ->
                if (isCellDead(grid, rowIndex, colIndex) && hasThreeLiveNeighbours(grid, rowIndex, colIndex) ) {
                    reproduceCell(grid, rowIndex, colIndex)
                }
            }
            return grid
        }

        private fun isCellDead(grid: Grid, rowIndex: Int, colIndex: Int) = grid.grid[rowIndex][colIndex] == DEAD

        private fun hasThreeLiveNeighbours(grid: Grid, rowIndex: Int, colIndex: Int) = grid.getLiveCells(rowIndex, colIndex) == 3

        private fun isOverPopulated(grid: Grid, rowIndex: Int, colIndex: Int) = grid.getLiveCells(rowIndex, colIndex) > MAX_POPULATION_LIMIT

        private fun isUnderPopulated(grid: Grid, rowIndex: Int, colIndex: Int) = grid.getLiveCells(rowIndex, colIndex) < MIN_POPULATION_LIMIT

        private fun isCellAlive(grid: Grid, rowIndex: Int, colIndex: Int) = grid.grid[rowIndex][colIndex] == ALIVE

        private fun reproduceCell(grid: Grid, rowIndex: Int, colIndex: Int) {
            grid.grid[rowIndex][colIndex] = ALIVE
        }

        private fun killCell(grid: Grid, rowIndex: Int, colIndex: Int) {
            grid.grid[rowIndex][colIndex] = DEAD
        }

        private fun iterateGrid(grid: Grid, callback: (rowIndex: Int, colIndex: Int) -> Unit) {
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    callback.invoke(rowIndex, colIndex)
                }
            }
        }

    }


}