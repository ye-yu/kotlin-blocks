@file:Suppress("unused")

package structs

enum class BoardItem(
    private val consoleColorFlag: String,
    val r: Double,
    val g: Double,
    val b: Double
) {
    NOTHING("\u001b[2;30m", .0, .0, .0),
    OUT_OF_BOUND("\u001B[2;30m ", .0, .0, .0),
    ORANGE("\u001B[0;33m", .0, .0, .0),
    RED("\u001B[0;31m", .0, .0, .0),
    GREEN("\u001B[0;32m", .0, .0, .0),
    BLUE("\u001B[0;34m", .0, .0, .0),
    YELLOW("\u001B[1;33m", .0, .0, .0),
    MAGENTA("\u001B[0;35m", .0, .0, .0),
    CYAN("\u001B[1;34m", .0, .0, .0),
    WHITE("\u001B[0;37m", .0, .0, .0),
    GREY("\u001B[1;30m", .0, .0, .0),
    PURPLE("\u001B[2;35m", .0, .0, .0),
    PINK("\u001B[1;35m", .0, .0, .0),
    ;

    companion object {
        const val RESET = "\u001B[m"
    }

    override fun toString(): String {
        return "$consoleColorFlag■$RESET"
    }
}
