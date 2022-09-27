package drivers

import structs.Board
import structs.BoardItem
import structs.BoardItemPiece
import java.util.concurrent.atomic.AtomicLong
import kotlin.random.Random

private fun <E, R> List<E>.mapAndFindNonNull(transformer: (E) -> R?): R? {
    for (i in this) {
        val r = transformer(i)
        if (r != null) return r
    }
    return null
}

object SearchUtil {
    private fun recursiveSearchSolution(board: Board, position: Pair<Int, Int>, depth: Int): Board? {
        val validPieces = BoardItemPiece.values().filter {
            BoardUtil.canPutSuppressed(board, it, position.first, position.second)
        }.sortedBy {
            random.nextDouble()
        }

        if (validPieces.isEmpty()) return null

        for (piece in validPieces) {
            BoardUtil.putBoardItemGroup(board, piece, position.first, position.second)

            val b = randomSearchSolution(board, depth + 1)
            if (b != null) return b
            BoardUtil.undoLastPosition(board)
            undos.incrementAndGet()
        }

        return null
    }

    fun randomSearchSolution(board: Board, depth: Int): Board? {
        if (!BoardUtil.isBoardValid(board)) {
            invalids.incrementAndGet()
            return null
        }
        this.printSearchBoard(board, depth)
        val snapshot = BoardUtil.reverseMapSnapshot(board).filter {
            it.first == BoardItem.NOTHING
        }.sortedBy {
            random.nextDouble()
        }

        if (snapshot.isEmpty()) return board

        return snapshot.mapAndFindNonNull { recursiveSearchSolution(board, it.second, depth) }
    }

    private val random = Random(0)

    private val atomicLong by lazy { AtomicLong(0) }
    private val undos by lazy { AtomicLong(0) }
    private val invalids by lazy { AtomicLong(0) }

    private fun printSearchBoard(board: Board, depth: Int) {
        val iterations = atomicLong.getAndIncrement()
        print("\u001B[H\u001B[2J")
        System.out.flush()
        println("Skipped: $invalids, Undos: $undos")
        println("Search Depth: $depth, iterations: $iterations")
        BoardUtil.printBoard(board)
    }

}