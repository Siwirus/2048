class Board(val width: Int, val height: Int) {
    var board: MutableList<MutableList<Cell>> = mutableListOf()
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
        return board.isEmpty()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Board
        if (this.board.isNotEmpty() && other.board.isNotEmpty()) {
            for (x in 0 until width) {
                for (y in 0 until height) {
                    if (this.board[x][y].value != other.board[x][y].value) return false
                }
            }
        }
        if (width != other.width) return false
        if (height != other.height) return false
        if (listOfFreeCell != other.listOfFreeCell) return false

        return true
    }


    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + board.hashCode()
        result = 31 * result + listOfFreeCell.hashCode()
        return result
    }
}



