package structs

class Board(val width: Int, val height: Int, val board: Array<Array<BoardItem>>) {
    val history = emptyArray<Pair<Pair<Int, Int>, BoardItemPiece>>().toMutableList()

    operator fun get(outer: Int, inner: Int): BoardItem {
        return if (outer < height && inner < width) board[outer][inner] else BoardItem.OUT_OF_BOUND
    }

    operator fun set(outer: Int, inner: Int, t: BoardItem) {
        board[outer][inner] = t
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
