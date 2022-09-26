package driver

import drivers.BoardUtil
import objects.LazyMutable
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import structs.Board
import structs.BoardItemGroup

class BoardUtilTest {

    var board: Board by LazyMutable { this.initializeBoard() }

    private fun initializeBoard(): Board {
        return BoardUtil.newBoard()
    }

    @BeforeEach
    fun beforeEach() {
        this.board = this.initializeBoard()
    }

    @Test
    fun canPutOnEmpty() {
        val item = BoardItemGroup.C_L_3
        val position = Pair(2, 1)

        assertTrue(BoardUtil.canPutSuppressed(this.board, item, position.first, position.second))
    }

    @Test
    fun cannotPutOnOverlap() {
        BoardUtil.putBoardItemGroup(board, BoardItemGroup.C_L_3, 2, 1)

        val item = BoardItemGroup.M_M_2
        val position = Pair(2, 0)

        assertFalse(BoardUtil.canPutSuppressed(this.board, item, position.first, position.second))
    }
}