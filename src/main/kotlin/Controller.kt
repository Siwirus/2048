class Controller {
    var gameBoard = Board(4, 4)
    fun right() {
        for (x in 2 downTo 0) {
            for (y in 0 until 4) {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when (gameBoard.board[x + i][y].value) {
                            null -> {
                                gameBoard.board[x + i][y].value = currentValue
                                gameBoard.board[x + i - 1][y].value = null
                                i++
                            }
                            currentValue -> {
                                gameBoard.board[x + i][y].value = currentValue!! * 2
                                gameBoard.board[x + i - 1][y].value = null
                                i++

                            }
                        }
                    } while (x + i < 3)


                }
            }
        }
        gameBoard.hasFreeCells()
        gameBoard.randomCell()

    }

    fun left() {
        for (x in 1 until 4) {
            for (y in 0 until 4) {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when (gameBoard.board[x - i][y].value) {
                            null -> {
                                gameBoard.board[x - i][y].value = currentValue
                                gameBoard.board[x - i + 1][y].value = null
                                i++
                            }
                            currentValue -> {
                                gameBoard.board[x - i][y].value = currentValue!! * 2
                                gameBoard.board[x - i + 1][y].value = null
                                i++

                            }
                        }
                    } while (x - i > 0)
                }
            }
        }
        gameBoard.hasFreeCells()
        gameBoard.randomCell()

    }


    fun down(){
        for (y in 2 downTo 0)  {
            for (x in 0 until 4)  {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when (gameBoard.board[x][y + i].value) {
                            null -> {
                                gameBoard.board[x][y + i].value = currentValue
                                gameBoard.board[x][y + i - 1].value = null
                                i++
                            }
                            currentValue -> {
                                gameBoard.board[x][y + i].value = currentValue!! * 2
                                gameBoard.board[x][y + i - 1].value = null
                                i++

                            }
                        }
                    } while (y + i < 3)
                }
            }
        }
        gameBoard.hasFreeCells()
        gameBoard.randomCell()

    }

    fun up(){
        for (y in 1 until 4)  {
            for (x in 0 until 4)  {
                if (gameBoard.board[x][y].value != null) {
                    var i = 1
                    val currentValue = gameBoard.board[x][y].value
                    do {
                        when (gameBoard.board[x][y - i].value) {
                            null -> {
                                gameBoard.board[x][y - i].value = currentValue
                                gameBoard.board[x][y - i + 1].value = null
                                i++
                            }
                            currentValue -> {
                                gameBoard.board[x][y - i].value = currentValue!! * 2
                                gameBoard.board[x][y - i + 1].value = null
                                i++

                            }
                        }
                    } while (y - i > 0)
                }
            }
        }
        gameBoard.hasFreeCells()
        gameBoard.randomCell()

    }
}

