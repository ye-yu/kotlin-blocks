import drivers.ArrayUtil
import drivers.BoardUtil
import structs.BoardItemGroupBase
import java.nio.file.Files
import kotlin.io.path.Path

fun main() {
    val s = StringBuilder()
    s.append(
        """
        package structs

        enum class BoardItemGroup(val positions: List<Pair<Int, Int>>, val item: BoardItem, val familyGroup: Int) {
    """.trimIndent()
    )
    for (boardItemGroup in BoardItemGroupBase.values()) {
        var positions = boardItemGroup.positions
        val existingPositions = emptyArray<List<Pair<Int, Int>>>().toMutableList()
        val rotateTask = {
            for (i in 0 until 4) {
                if (!ArrayUtil.hasCoordinatesGroup(existingPositions, positions)) {
                    existingPositions += positions
                }

                positions = ArrayUtil.rotateCoords(positions)
            }
        }

        rotateTask()
        positions = ArrayUtil.pairFlip(positions)
        rotateTask()

        val width = existingPositions.foldRight(-1) { a, acc ->
            acc + a.foldRight(0) { b, bcc ->
                bcc.coerceAtLeast(b.first)
            } + 2
        }

        val height = boardItemGroup.positions.foldRight(0) { es, acc ->
            acc.coerceAtLeast(es.first).coerceAtLeast(es.second)
        } + 1

        val board = BoardUtil.newBoard(width, height)

        var xOffset = 0

        for ((idx, coords) in existingPositions.withIndex()) {
            val w = coords.foldRight(0) { es, acc -> acc.coerceAtLeast(es.first) } + 1
            val h = coords.foldRight(0) { es, acc -> acc.coerceAtLeast(es.second) } + 1

            val docArr = Array(h) {
                Array(w) {
                    " "
                }.toMutableList()
            }.toMutableList()


            for (coordinate in coords) {
                val x = xOffset + coordinate.first
                val y = coordinate.second
                board[y, x] = boardItemGroup.item
                docArr[y][coordinate.first] = "${boardItemGroup.item.name.toCharArray()[0]}"
            }
            xOffset += coords.foldRight(0) { i, a -> a.coerceAtLeast(i.first) } + 2

            val shape = "\n" + docArr.joinToString("\n") { "                     *   ${it.joinToString(" ")}" }
            val pair =
                "\n" + coords.joinToString(",\n") { "                            Pair(${it.first}, ${it.second})" }
            s.append("\n")
            s.append(
                """
                    /**
                     * Colour: ${boardItemGroup.item.name}
                     *
                     * Shape:
                     * ```${shape}
                     * ```
                     */
                    ${boardItemGroup.name.substring(0, boardItemGroup.name.length - 1) + idx}(
                        listOf($pair
                        ),
                        BoardItem.${boardItemGroup.item.name},
                        ${boardItemGroup.ordinal}
                    ),
            """.replaceIndent("    ")
            )
            s.append("\n")
        }
    }

    s.append("\n}")

    val writePath = Path(System.getProperty("user.dir"), "src/main/kotlin/structs/BoardItemGroup.kt")

    Files.newBufferedWriter(writePath).use { block ->
        block.write(s.toString())
    }
}
