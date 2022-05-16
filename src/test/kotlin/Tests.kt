import org.junit.Test
import kotlin.test.assertEquals
import java.io.File
import kotlin.math.pow
import kotlin.test.assertTrue


class Tests {
    @Test
    fun test1() {
        val board = Board(4, 4)
        assertTrue(board.creationOfBoard())
        assertTrue(board.hasFreeCells())
        for (i in 0..13) {
            board.hasFreeCells()
            board.randomCell()
        }
        for (x in 0..3) {
            for (y in 0..3) {
               println(board.board[x][y].value)
            }

        }
        assertTrue(board.hasFreeCells())
    }
}

