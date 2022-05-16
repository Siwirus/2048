import org.junit.Test
import kotlin.test.assertEquals
import java.io.File
import kotlin.math.pow
import kotlin.test.assertTrue


class Tests {
    @Test
    fun test1() {
        val boradCont = Controller()
        val board = boradCont.gameBoard
        assertTrue(board.creationOfBoard())
        assertTrue(board.hasFreeCells())
        for (i in 0..13) {
            board.hasFreeCells()
            board.randomCell()
        }
        for (x in 0..3) {
            println(" ")
            for (y in 0..3) {
                print(board.board[x][y].value)
                print("  ")
            }

        }
        println("")
        boradCont.down()
        boradCont.left()
        boradCont.up()
        boradCont.right()

        for (x in 0..3) {
            println(" ")
            for (y in 0..3) {
                print(board.board[x][y].value)
                print("  ")
            }

        }


        assertTrue(board.hasFreeCells())
    }
}

