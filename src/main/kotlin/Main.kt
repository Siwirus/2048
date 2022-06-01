import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*

@OptIn(ExperimentalUnitApi::class)
@ExperimentalComposeUiApi
fun main() = application {
    var list by remember {
        controller1.gameBoard.creationOfBoard()
        mutableStateOf(controller1.gameBoard.board)
    }
    Window(
        onKeyEvent = {
            if (it.type == KeyEventType.KeyUp) {
                when (it.key) {
                    Key.DirectionDown -> {
                        down()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                        println("     ")
                    }
                    Key.DirectionUp -> {
                        up()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                        println("     ")
                    }
                    Key.DirectionRight -> {
                        right()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                        println("     ")
                    }
                    Key.DirectionLeft -> {
                        left()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                        println("     ")

                    }
                }
            }
            true
        },
        onCloseRequest = ::exitApplication,
        title = "2048",
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            width = 800.dp,
            height = 600.dp
        ),
    ) {

        MaterialTheme {
            controller.gameBoard.beginOfGame()
                Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Column {
                    for (line in list) {
                        Row {
                            for (cell in line) {
                                Box(
                                    modifier = Modifier.size(Dp(80f)).background(
                                        color = when (cell.value) {
                                            null -> Color.LightGray
                                            2 -> Color(255, 237, 222)
                                            4 -> Color(255, 226, 201)
                                            8 -> Color(254, 199, 153)
                                            16 -> Color(255, 143, 49)
                                            32 -> Color(207, 94, 0)
                                            64 -> Color(199, 0, 57)
                                            128 -> Color(255, 234, 127)
                                            256 -> Color(255, 213, 2)
                                            512 -> Color(240, 212, 68)
                                            1024 -> Color(255, 195, 0)
                                            2048 -> Color(255, 195, 0)
                                            else -> Color.LightGray
                                        }
                                    )
                                ) {
                                    Text(
                                        fontSize = TextUnit(28f, TextUnitType.Sp),
                                        text = if (cell.value == null) "" else cell.value.toString(),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.align(Alignment.Center)

                                    )
                                }
                            }
                        }
                    }
                }
            }
            MenuBar {
                Menu("Actions") {
                    Item("Restart", onClick = {
                        restart()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                    })
                }
            }
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(
                    shape = CircleShape,
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(229, 213, 159)),
                    onClick = {
                        left()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                        println("     ")
                    }) {
                    Text(
                        color = Color(0, 0, 0),
                        text = "Left"
                    )
                }
                Column(Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedButton(
                        shape = CircleShape,
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(229, 213, 159)),
                        onClick = {
                            up()
                            list = controller1.gameBoard.board
                            list = controllerBoard
                            controller.printBoard()
                            println("     ")
                        }) {
                        Text(
                            color = Color(0, 0, 0),
                            text = "Up"
                        )
                    }

                    OutlinedButton(
                        shape = CircleShape,
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(229, 213, 159)),
                        onClick = {
                            down()
                            list = controller1.gameBoard.board
                            list = controllerBoard
                            controller.printBoard()
                            println("     ")
                        }) {
                        Text(
                            color = Color(0, 0, 0),
                            text = "Down"
                        )
                    }
                }
                OutlinedButton(
                    shape = CircleShape,
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(229, 213, 159)),
                    onClick = {
                        right()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                        println("     ")
                    }) {
                    Text(
                        color = Color(0, 0, 0),
                        text = "Right"
                    )
                }
            }


            if (isLose() || isWin()) {
                OutlinedButton(
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(229, 213, 159)),
                    onClick = {
                        restart()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        controller.printBoard()
                    },

                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        color = Color(0, 0, 0),
                        text = "You $stateOfGame, your score: $score"
                    )
                }
            }
        }
    }

}




