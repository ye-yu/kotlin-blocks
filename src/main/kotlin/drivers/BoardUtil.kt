package drivers

import structs.Board
import structs.BoardItem
import structs.BoardItemPiece
import java.util.concurrent.atomic.AtomicInteger

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

    fun isBoardValid3(board: Board): Boolean {
        val nothingnessGroups = getAllNothingnessGroups(board)
        val canSkip = board.history.map { it.second.familyGroup }.toSet()
        return nothingnessGroups.all { clusterCoordsList -> canClusterFitAnyPieces(clusterCoordsList.toSet(), canSkip) }
    }

    /**
     * Returns groups of coordinates where each forms a nothingness region
     */
    fun getAllNothingnessGroups(board: Board): List<List<Pair<Int, Int>>> {
        val dataPoints = board.board.flatMapIndexed { outer, row ->
            row.mapIndexed { inner, item ->
                Pair(Pair(outer, inner), item)
            }.filter { it.second == BoardItem.NOTHING }
        }

        // at first, set each spot into their own cluster
        var cluster: MutableList<MutableList<Pair<Int, Int>>> =
            dataPoints.map { mutableListOf(it.first) }.toMutableList()

        var iterations = 0

        while (true) {
            if (++iterations > 6000) throw IllegalStateException("More than 6000 cluster iterations")
            // reset shouldRepeat to empty state
            var shouldRepeat = false
            val clusterReverseMap = cluster.mapIndexed { index, pairs ->
                Pair(index, pairs)
            }.foldRight(mutableMapOf<Pair<Int, Int>, Int>()) { points, acc ->
                points.second.forEach {
                    acc[it] = points.first
                }
                acc
            }
            val neighbors: MutableMap<Int, Int> = mutableMapOf()

            cluster.forEachIndexed { index, clusterPoints ->
                clusterPoints.forEach { point ->
                    val notFound = point.allDirectional().find {
                        clusterReverseMap[it] != null
                                && clusterReverseMap[it] != index
                                && neighbors[clusterReverseMap[it]] == null
                    }?.let {
                        neighbors[clusterReverseMap[it]!!] = index
                        shouldRepeat = true
                        it
                    } == null

                    if (notFound && neighbors[index] == null) {
                        neighbors[index] = index
                    }
                }
            }

            if (!shouldRepeat) break

            val neighborsByIdReverseMap: MutableMap<Int, Int> = mutableMapOf()
            val neighborsById: MutableMap<Int, MutableSet<Int>> = mutableMapOf()

            val atomicInt = AtomicInteger(0)

            neighbors.entries.forEach { (n1, n2) ->
                val id = neighborsByIdReverseMap[n1] ?: neighborsByIdReverseMap[n2] ?: atomicInt.getAndIncrement()
                val mutableSet = neighborsById[id] ?: mutableSetOf()
                mutableSet += n1
                mutableSet += n2
                neighborsById[id] = mutableSet
                neighborsByIdReverseMap[n1] = id
                neighborsByIdReverseMap[n2] = id
            }

            cluster = neighborsById.values.map { index ->
                index.flatMap { cluster[it] }.toMutableList()
            }.toMutableList()
        }

        val msg = "Done in $iterations iterations."
        print(msg)
        print("\b".repeat(msg.length))

        return cluster
    }

    fun canClusterFitAnyPieces(
        clusterCoords: Set<Pair<Int, Int>>,
        except: Set<Int>,
        onPieceFound: (Pair<Int, Int>, BoardItemPiece) -> Unit = { _, _ -> }
    ): Boolean {
        return BoardItemPiece.PIECES_BY_FAMILY_GROUP.any { (family, pieces) ->
            !except.contains(family) && pieces.any { piece ->
                clusterCoords.find { (y, x) ->
                    piece.positions.map { (deltaY, deltaX) ->
                        Pair(y + deltaY, x + deltaX)
                    }.toSet().isSubsetOf(clusterCoords)
                }.let {
                    if (it != null) {
                        onPieceFound(it, piece)
                    }
                    return it != null
                }
            }
        }
    }
}

private fun <E> Set<E>.isSubsetOf(predicate: Set<E>): Boolean {
    return this.all { predicate.contains(it) }
}

private fun Pair<Int, Int>.up(): Pair<Int, Int> {
    return Pair(this.first - 1, this.second)
}

private fun Pair<Int, Int>.down(): Pair<Int, Int> {
    return Pair(this.first + 1, this.second)
}

private fun Pair<Int, Int>.left(): Pair<Int, Int> {
    return Pair(this.first, this.second - 1)
}

private fun Pair<Int, Int>.right(): Pair<Int, Int> {
    return Pair(this.first, this.second + 1)
}

private fun Pair<Int, Int>.allDirectional(): List<Pair<Int, Int>> {
    return listOf(this.up(), this.down(), this.left(), this.right())
}
