package drivers

import structs.Board
import structs.BoardItem
import structs.BoardItemGroup

object BoardUtil {
    fun newBoard(): Board {
        val width = 11
        val height = 5
        val a = Array(height) {
            Array(width) {
                BoardItem.NOTHING
            }
        }
        return Board(width, height, a)
    }

    fun printBoard(board: Board) {
        print("  ")
        for (w in 0 until board.width) {
            print("$w ")
        }
        println()
        var h = 0
        board.board.forEach {
            val row = it.joinToString(" ")
            println("${h++} $row")
        }
    }

    fun putBoardItemGroup(board: Board, item: BoardItemGroup, x: Int, y: Int, undo: Boolean = false) {
        if (!undo) {
            check(item.positions.all { board[it.first + x, it.second + y] == BoardItem.NOTHING }) {
                "Collision at ${
                    item.positions.joinToString(", ") {
                        "(${Pair(it.first + x, it.second + y).toList().joinToString(", ")})"
                    }
                }"
            }

            check(item.positions.none { board[it.first + x, it.second + y] == BoardItem.OUT_OF_BOUND }) {
                "Out of bound at $x, $y"
            }
        }

        val itemToPut = if (undo) BoardItem.NOTHING else item.item
        item.positions.forEach {
            val deltaX = it.second
            val deltaY = it.first
            val xPos = deltaX + x
            val yPos = deltaY + y
            board[xPos, yPos] = itemToPut
        }

        board.history += Pair(Pair(x, y), item)
    }

    fun undoLastPosition(board: Board) {
        val last = board.history.removeLast()
        last.first.let {
            val x = it.first
            val y = it.second
            val shape = last.second
            putBoardItemGroup(board, shape, x, y, true)
        }
    }
}