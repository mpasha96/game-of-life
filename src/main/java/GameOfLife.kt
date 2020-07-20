class GameOfLife {


    companion object {

        fun applyRules(grid: Grid): Grid {

            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        killCellIfUnderPopulation(grid, rowIndex, colIndex)
                        killCellIfOverPopulation(grid, rowIndex, colIndex)
                        reproduceCellIfExactlyThreeLiveNeighbours(grid, rowIndex, colIndex)
                    }
                }
            }
            return grid
        }

        private fun killCellIfUnderPopulation(grid: Grid, rowIndex: Int, colIndex: Int) {
            val liveCells = grid.getLiveCells(rowIndex, colIndex)
            if (liveCells < 2 && grid.grid[rowIndex][colIndex] == 1) {
                grid.grid[rowIndex][colIndex] = 0
            }
        }

        private fun killCellIfOverPopulation(grid: Grid, rowIndex: Int, colIndex: Int) {
            val liveCells = grid.getLiveCells(rowIndex, colIndex)
            if (liveCells > 3 && grid.grid[rowIndex][colIndex] == 1) {
                grid.grid[rowIndex][colIndex] = 0
            }
        }

        private fun reproduceCellIfExactlyThreeLiveNeighbours(grid: Grid, rowIndex: Int, colIndex: Int) {
            val liveCells = grid.getLiveCells(rowIndex, colIndex)
            if (liveCells == 3 && grid.grid[rowIndex][colIndex] == 0) {
                grid.grid[rowIndex][colIndex] = 1
            }
        }

    }


}