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
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        if (isUnderPopulated(grid, rowIndex, colIndex) && isCellAlive(grid, rowIndex, colIndex)) {
                            killCell(grid, rowIndex, colIndex)
                        }
                    }
                }
            }
            return grid
        }

        fun keepCellAliveIfTwoOrThreeLiveNeighboursPresent(grid: Grid): Grid {
            return grid // as if we dont need to change anything here
        }

        fun killCellIfOverPopulation(grid: Grid): Grid {
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        if (isOverPopulated(grid, rowIndex, colIndex) && isCellAlive(grid, rowIndex, colIndex)) {
                            killCell(grid, rowIndex, colIndex)
                        }
                    }
                }
            }
            return grid
        }


        fun reproduceCellIfExactlyThreeLiveNeighbours(grid: Grid): Grid {
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        if (hasThreeLiveNeighbours(grid, rowIndex, colIndex) && !isCellAlive(grid, rowIndex, colIndex)) {
                            reproduceCell(grid, rowIndex, colIndex)
                        }
                    }
                }
            }
            return grid
        }

//        fun reproduceCellIfExactlyThreeLiveNeighboursWithCallback(grid: Grid): Grid {
//
//        }

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

        private fun iterateGrid(grid: Grid, callback: (row: Int, col: Int) -> Unit) {
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    callback.invoke(rowIndex, colIndex)
                }
            }
        }

    }


}