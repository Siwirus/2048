val controller = Controller()
val controller1 = Controller()
var controllerBoard = controller.gameBoard.board
var score = controller.score
var stateOfGame = ""

fun isLose(): Boolean {
    val other = Controller()
    other.gameBoard.beginOfGame()
    for (x in 0 until 4) {
        for (y in 0 until 4) {
            other.gameBoard.board[x][y].value = controllerBoard[x][y].value
        }
    }
    other.right()
    other.left()
    other.up()
    other.down()
    stateOfGame = "lose"
    return other.gameBoard.board == controllerBoard
}
fun isWin(): Boolean {
    for (x in 0 until 4) {
        for (y in 0 until 4) {
            if (controllerBoard[x][y].value == 2048) {
                stateOfGame = "win"
                return true
            }
        }
    }
    return false
}


fun left() {
    controller.gameBoard.beginOfGame()
    controller.left()
    score = controller.score
}

fun right() {
    controller.gameBoard.beginOfGame()
    controller.right()
    score = controller.score
}

fun down() {
    controller.gameBoard.beginOfGame()
    controller.down()
    score = controller.score
}

fun up() {
    controller.gameBoard.beginOfGame()
    controller.up()
    score = controller.score
}

fun restart() {
    controller.gameBoard.board = mutableListOf()
    controller.gameBoard.beginOfGame()
    controllerBoard = controller.gameBoard.board
}




