package drivers

import structs.Board
import structs.BoardItem
import structs.BoardItemPiece

object BoardUtil {
    fun newBoard(): Board {
        return newBoard(11, 5)
    }

    fun newBoard(width: Int = 11, height: Int = 5): Board {
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

    fun putBoardItemGroup(board: Board, item: BoardItemPiece, x: Int, y: Int, undo: Boolean = false) {
        if (!undo) {
            canPut(board, item, x, y)
        }

        val itemToPut = if (undo) BoardItem.NOTHING else item.item
        item.positions.forEach {
            val deltaY = it.first
            val deltaX = it.second
            val yPos = deltaY + y
            val xPos = deltaX + x
            board[yPos, xPos] = itemToPut
        }

        if (!undo) {
            board.history += Pair(Pair(y, x), item)
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun canPut(board: Board, item: BoardItemPiece, x: Int, y: Int) {
        check(item.positions.all { board[it.first + y, it.second + x] == BoardItem.NOTHING }) {
            "Collision at ${
                item.positions.joinToString(", ") {
                    "(${Pair(it.first + y, it.second + x).toList().joinToString(", ")})"
                }
            }"
        }

        check(item.positions.none { board[it.first + y, it.second + x] == BoardItem.OUT_OF_BOUND }) {
            "Out of bound at $x, $y"
        }

        check(
            !board.history.foldRight(emptySet<Int>().toMutableSet()) { it, acc ->
                acc += it.second.familyGroup
                acc
            }.contains(item.familyGroup)
        ) {
            "Board already have ${item.familyGroup} piece group"
        }
    }

    fun canPutSuppressed(board: Board, item: BoardItemPiece, x: Int, y: Int): Boolean {
        return try {
            canPut(board, item, x, y)
            true
        } catch (_ignored: Exception) {
            false
        }
    }

    fun undoLastPosition(board: Board) {
        val last = board.history.removeLast()
        last.first.let {
            val y = it.first
            val x = it.second
            val shape = last.second
            putBoardItemGroup(board, shape, x, y, true)
        }
    }

    fun reverseMapSnapshot(board: Board): List<Pair<BoardItem, Pair<Int, Int>>> {
        return board.board.flatMapIndexed { y, row ->
            row.mapIndexed { x, boardItem ->
                Pair(boardItem, Pair(x, y))
            }
        }
    }

    /**
     * Checks if the board state can fill any of the remaining family pieces
     */
    fun isBoardValid(board: Board): Boolean {
        val availablePieces = board.history.map { it.second.familyGroup }.toSortedSet()
        return BoardItemPiece.PIECES_BY_FAMILY_GROUP.entries.all { (key, value) ->
            availablePieces.contains(key) || ArrayUtil.anyIndexed(board.board.iterator()) { outer, row ->
                ArrayUtil.anyIndexed(row.iterator()) { inner, _ ->
                    value.any { canPutSuppressed(board, it, inner, outer) }
                }
            }
        }
    }

    /**
     * Checks if the board nothing state has at least one nothing neighbor
     */
    fun isBoardValid2(board: Board): Boolean {
        for ((outer, row) in board.board.withIndex()) {
            for ((inner, item) in row.withIndex()) {
                if (item != BoardItem.NOTHING) continue
                var nothing = 0
                if (board[outer - 1, inner] == BoardItem.NOTHING) ++nothing
                if (board[outer + 1, inner] == BoardItem.NOTHING) ++nothing
                if (board[outer, inner - 1] == BoardItem.NOTHING) ++nothing
                if (board[outer, inner + 1] == BoardItem.NOTHING) ++nothing
                if (nothing == 0) return false
            }
        }
        return true
    }
}