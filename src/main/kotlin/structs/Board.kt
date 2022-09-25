package structs

class Board(val width: Int, val height: Int, val board: Array<Array<BoardItem>>) {
    val history = emptyArray<Pair<Pair<Int, Int>, BoardItemGroup>>().toMutableList()

    operator fun get(x: Int, y: Int): BoardItem {
        return if (x < width && y < height) board[x][y] else BoardItem.OUT_OF_BOUND
    }

    operator fun set(x: Int, y: Int, t: BoardItem) {
        board[x][y] = t
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Board

        if (width != other.width) return false
        if (height != other.height) return false
        if (!board.contentDeepEquals(other.board)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + board.contentDeepHashCode()
        return result
    }
}
