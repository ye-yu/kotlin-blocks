import drivers.BoardUtil
import structs.BoardItem

fun main() {
    val board = BoardUtil.newBoard(5, 5)
    board[0, 2] = BoardItem.WHITE
    board[1, 2] = BoardItem.WHITE

    board[3, 0] = BoardItem.WHITE
    board[3, 1] = BoardItem.WHITE
    board[4, 0] = BoardItem.WHITE
    board[4, 1] = BoardItem.WHITE
    board[4, 2] = BoardItem.WHITE

    board[2, 4] = BoardItem.WHITE

    val boardItems =
        BoardItem.values().filter { it != BoardItem.WHITE && it != BoardItem.NOTHING && it != BoardItem.OUT_OF_BOUND }

    BoardUtil.printBoard(board)

    val nothingness = BoardUtil.getAllNothingnessGroups(board)

    println("Found ${nothingness.size} clusters")

    nothingness.forEachIndexed { index, pairs ->
        val item = boardItems[index % boardItems.size]
        pairs.forEach { (x, y) -> board[x, y] = item }
    }

    BoardUtil.printBoard(board)
}