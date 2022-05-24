import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import kotlin.concurrent.timer

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "2048",
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            width = 800.dp,
            height = 600.dp
        ),
    ) {
        val controller = Controller()
        val controller1 = Controller()
        val controllerBoard = controller.gameBoard.board

        MaterialTheme {
            var list by remember {
                controller1.gameBoard.creationOfBoard()
                mutableStateOf(controller1.gameBoard.board)
            }

                Column {
                    Column {
                        for (line in list) {
                            Row {
                                for (cell in line) {
                                    Box(modifier = Modifier.size(Dp(40f)).background(Color.LightGray)) {
                                        Text(if (cell.value == null) "" else cell.value.toString())
                                    }
                                }
                            }
                        }
                    }
                }



            MenuBar {
                Menu("Actions") {
                    Item("Restart", onClick = {

                    })
                }
            }
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(modifier = Modifier,
                    onClick = {
                        if (controllerBoard.isEmpty()) controller.gameBoard.beginOfGame()
                        controller.left()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        for (x in 0..3) {
                            println(" ")
                            for (y in 0..3) {
                                if (controllerBoard[x][y].value == null) print(0)
                                else print(controllerBoard[x][y].value)
                                print("  ")
                            }
                        }
                        println("     ")
                    }) {
                    Text("Left")
                }
                Column(Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(modifier = Modifier,
                        onClick = {
                            if (controllerBoard.isEmpty()) controller.gameBoard.beginOfGame()
                            controller.up()
                            list = controller1.gameBoard.board
                            list = controllerBoard
                            for (x in 0..3) {
                                println(" ")
                                for (y in 0..3) {
                                    if (controllerBoard[x][y].value == null) print(0)
                                    else print(controllerBoard[x][y].value)
                                    print("  ")
                                }
                            }
                            println("    ")
                        }) {
                        Text("Up")
                    }

                    Button(modifier = Modifier,
                        onClick = {
                            if (controllerBoard.isEmpty()) controller.gameBoard.beginOfGame()
                            controller.down()
                            list = controller1.gameBoard.board
                            list = controllerBoard
                            for (x in 0..3) {
                                println(" ")
                                for (y in 0..3) {
                                    if (controllerBoard[x][y].value == null) print(0)
                                    else print(controllerBoard[x][y].value)
                                    print("  ")
                                }
                            }
                            println("     ")
                        }) {
                        Text("Down")
                    }
                }
                Button(modifier = Modifier,
                    onClick = {
                        if (controllerBoard.isEmpty()) controller.gameBoard.beginOfGame()
                        controller.right()
                        list = controller1.gameBoard.board
                        list = controllerBoard
                        for (x in 0..3) {
                            println(" ")
                            for (y in 0..3) {
                                if (controllerBoard[x][y].value == null) print(0)
                                else print(controllerBoard[x][y].value)
                                print("  ")
                            }
                        }
                        println("     ")
                    }) {
                    Text("Right")
                }
            }


        }
    }
}



