class Board(val width: Int, val height: Int) {
    var board = mutableListOf(mutableListOf<Cell>())
    var listOfFreeCell = mutableListOf<Cell>()

    fun creationOfBoard(): Boolean {
        for (x in 0 until width) {
            board.add(mutableListOf())
            for (y in 0 until height) {
                board[x].add(Cell(x, y, null))
            }
        }
        return true
    }

    fun randomCell(): Boolean {
        val randomValue = listOf(2, 4)
        val randomCell = listOfFreeCell.random()
        if (this.hasFreeCells()) {
            board[randomCell.x][randomCell.y].value = randomValue.random()
        }
        return true
    }


    fun hasFreeCells(): Boolean {
        listOfFreeCell = mutableListOf()
        for (x in 0 until width) {
            listOfFreeCell += board[x].filter { it.value == null }
        }
        return listOfFreeCell.isNotEmpty()
    }

    fun beginOfGame(): Boolean {
        if (board.isEmpty()) {
            this.creationOfBoard()
            this.hasFreeCells()
            this.randomCell()
        }
        return true
    }
}



