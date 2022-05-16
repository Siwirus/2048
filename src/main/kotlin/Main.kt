import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

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

        MaterialTheme {
            MenuBar {
                Menu("Actions") {
                    Item("Restart", onClick = {
                    })
                }
            }
            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
                Button(modifier = Modifier,
                    onClick = {
                    }) {
                    Text("Left")
                }
                Column(Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(modifier = Modifier,
                        onClick = {
                        }) {
                        Text("Up")
                    }

                    Button(modifier = Modifier,
                        onClick = {
                        }) {
                        Text("Down")
                    }
                }
                Button(modifier = Modifier,
                    onClick = {
                    }) {
                    Text("Right")
                }
            }


        }
    }
}
@Composable
fun App1(){
    val board = Board(4, 4)
    board.beginOfGame()

}


