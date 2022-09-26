import drivers.BoardUtil
import drivers.SearchUtil

fun main() {
    val board = BoardUtil.newBoard()
    val completed = SearchUtil.randomSearchSolution(board, 0)
    if (completed == null) {
        println("Solution not found")
    } else {
        println("Solution found")
        BoardUtil.printBoard(board)
    }
}