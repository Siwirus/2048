val controller = Controller()
val controller1 = Controller()
var controllerBoard = controller.gameBoard.board
//255, 237, 222  2
// 255, 226, 201     4
//254, 199, 153       8
// 255, 143, 49      16
//207, 94, 0        32
//199, 0, 57        64
//255, 234, 127         128
//255, 213, 2          256
//240, 212, 68       512
//255, 195, 0
//255, 195, 0



fun left() {
    controller.gameBoard.beginOfGame()
    controller.left()

}

fun right() {
    controller.gameBoard.beginOfGame()
    controller.right()


}

fun down() {
    controller.gameBoard.beginOfGame()
    controller.down()


}

fun up() {
    controller.gameBoard.beginOfGame()
    controller.up()


}

fun restart() {
    controller.gameBoard.board = mutableListOf()
    controller.gameBoard.beginOfGame()
    controllerBoard = controller.gameBoard.board

}




