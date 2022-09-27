import drivers.BoardUtil
import structs.BoardItemPiece

fun main() {
    val board = BoardUtil.newBoard()
    BoardUtil.printBoard(board)

    for (i in BoardItemPiece.values()) {
        println()
        println("===== ${i.name} =====")
        println()
        BoardUtil.putBoardItemGroup(board, i, 0, 0)
        BoardUtil.printBoard(board)
        BoardUtil.undoLastPosition(board)
    }
}