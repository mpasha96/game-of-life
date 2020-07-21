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
                        val liveCells = grid.getLiveCells(rowIndex, colIndex)
                        if (liveCells < 2 && grid.grid[rowIndex][colIndex] == 1) {
                            grid.grid[rowIndex][colIndex] = 0
                        }
                    }
                }
            }
            return grid
        }

        fun keepCellAliveIfTwoOrThreeLiveNeighboursPresent(grid: Grid): Grid {
            // as if we dont need to change anything here
            return grid
        }

        fun killCellIfOverPopulation(grid: Grid): Grid {
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
            return grid
        }

        fun reproduceCellIfExactlyThreeLiveNeighbours(grid: Grid): Grid {
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
            return grid
        }

    }


}