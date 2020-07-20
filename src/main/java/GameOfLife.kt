class GameOfLife {


    companion object {

        fun applyRule(grid: Grid): Grid {

            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        applyUnderPopulationRule(grid, rowIndex, colIndex)
                    }
                }
            }
            return grid
        }

        private fun applyUnderPopulationRule(grid: Grid, rowIndex: Int, colIndex: Int) {
            val liveCells = grid.getLiveCells(rowIndex, colIndex)
            if (liveCells < 2 && grid.grid[rowIndex][colIndex] == 1) {
                grid.grid[rowIndex][colIndex] = 0
            }
        }

    }


}