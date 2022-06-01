class Controller {
    private var stepValue = 0
    var gameBoard = Board(4, 4)
    var score = 0
    fun down() {
        gameBoard.hasFreeCells()
        val freeCells = gameBoard.listOfFreeCell
        for (y in 0 until 4) {
            stepValue = 0
            for (x in 2 downTo 0) {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when {
                            gameBoard.board[x + i][y].value == null -> {
                                gameBoard.board[x + i][y].value = currentValue
                                gameBoard.board[x + i - 1][y].value = null
                                i++
                            }
                            (gameBoard.board[x + i][y].value == currentValue && stepValue !=
                                    currentValue) -> {
                                gameBoard.board[x + i][y].value = currentValue!! * 2
                                gameBoard.board[x + i - 1][y].value = null
                                stepValue = currentValue * 2
                                i++
                                score += currentValue * 2
                            }
                            gameBoard.board[x + i][y].value != currentValue -> break
                            else -> break
                        }
                    } while (x + i <= 3)


                }
            }
        }
        gameBoard.hasFreeCells()
        if (freeCells != gameBoard.listOfFreeCell) gameBoard.randomCell()

    }

    fun up() {
        gameBoard.hasFreeCells()
        val freeCells = gameBoard.listOfFreeCell
        for (y in 0 until 4) {
            stepValue = 0
            for (x in 1 until 4) {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when {
                            gameBoard.board[x - i][y].value == null -> {
                                gameBoard.board[x - i][y].value = currentValue!!
                                gameBoard.board[x - i + 1][y].value = null
                                i++
                            }
                            (gameBoard.board[x - i][y].value == currentValue &&
                                    stepValue != currentValue) -> {
                                gameBoard.board[x - i][y].value = currentValue!! * 2
                                gameBoard.board[x - i + 1][y].value = null
                                stepValue = currentValue * 2
                                i++
                                score += currentValue * 2
                            }
                            gameBoard.board[x - i][y].value != currentValue -> break
                            else -> break

                        }
                    } while (x - i >= 0)
                }
            }
        }


        gameBoard.hasFreeCells()
        if (freeCells != gameBoard.listOfFreeCell) gameBoard.randomCell()


    }


    fun right() {
        gameBoard.hasFreeCells()
        val freeCells = gameBoard.listOfFreeCell
        for (x in 0 until 4) {
            stepValue = 0
            for (y in 2 downTo 0) {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when {
                            gameBoard.board[x][y + i].value == null -> {
                                gameBoard.board[x][y + i].value = currentValue
                                gameBoard.board[x][y + i - 1].value = null
                                i++
                            }
                            (gameBoard.board[x][y + i].value == currentValue &&
                                    stepValue != currentValue) -> {
                                gameBoard.board[x][y + i].value = currentValue!! * 2
                                gameBoard.board[x][y + i - 1].value = null
                                stepValue = currentValue * 2
                                i++
                                score += currentValue * 2
                            }
                            gameBoard.board[x][y + i].value != currentValue -> break
                            else -> break

                        }
                    } while (y + i <= 3)
                }
            }
        }

        gameBoard.hasFreeCells()
        if (freeCells != gameBoard.listOfFreeCell) gameBoard.randomCell()


    }

    fun left() {
        gameBoard.hasFreeCells()
        val freeCells = gameBoard.listOfFreeCell
        for (x in 0 until 4) {
            stepValue = 0
            for (y in 1 until 4) {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when {
                            gameBoard.board[x][y - i].value == null -> {
                                gameBoard.board[x][y - i].value = currentValue
                                gameBoard.board[x][y - i + 1].value = null
                                i++
                            }
                            (gameBoard.board[x][y - i].value == currentValue &&
                                    stepValue != currentValue) -> {
                                gameBoard.board[x][y - i].value = currentValue!! * 2
                                gameBoard.board[x][y - i + 1].value = null
                                stepValue = currentValue * 2
                                i++
                                score += currentValue * 2
                            }
                            gameBoard.board[x][y - i].value != currentValue -> break
                            else -> break
                        }
                    } while (y - i >= 0)
                }
            }
        }
        gameBoard.hasFreeCells()
        if (freeCells != gameBoard.listOfFreeCell) gameBoard.randomCell()

    }

    fun printBoard() {
        for (x in 0..3) {
            println(" ")
            for (y in 0..3) {
                if (gameBoard.board[x][y].value == null) print(0)
                else print(gameBoard.board[x][y].value)
                print("  ")
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Controller

        if (gameBoard != other.gameBoard) return false

        return true
    }

    override fun hashCode(): Int {
        return gameBoard.hashCode()
    }
}

