class GameOfLife {

    companion object {

        fun applyRules(grid: Grid): Grid {

            killCellIfUnderPopulation(grid)
            killCellIfOverPopulation(grid)
            reproduceCellIfExactlyThreeLiveNeighbours(grid)

            return grid
        }

        private fun killCellIfUnderPopulation(grid: Grid) {
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        val liveCells = grid.getLiveCells(rowIndex, colIndex)
                        if (liveCells < 2 && grid.grid[rowIndex][colIndex] == 1) {
                            grid.grid[rowIndex][colIndex] = 0
                        }
                    }
                }
            }
        }

        private fun killCellIfOverPopulation(grid: Grid) {
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        val liveCells = grid.getLiveCells(rowIndex, colIndex)
                        if (liveCells > 3 && grid.grid[rowIndex][colIndex] == 1) {
                            grid.grid[rowIndex][colIndex] = 0
                        }
                    }
                }
            }
        }

        private fun reproduceCellIfExactlyThreeLiveNeighbours(grid: Grid) {
            grid.grid.forEachIndexed { rowIndex, rowItem ->
                rowItem.forEachIndexed { colIndex, _ ->
                    run {
                        val liveCells = grid.getLiveCells(rowIndex, colIndex)
                        if (liveCells == 3 && grid.grid[rowIndex][colIndex] == 0) {
                            grid.grid[rowIndex][colIndex] = 1
                        }
                    }
                }
            }
        }

    }


}