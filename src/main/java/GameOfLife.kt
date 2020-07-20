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


}