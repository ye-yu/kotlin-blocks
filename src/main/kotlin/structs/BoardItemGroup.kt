package structs

enum class BoardItemGroup(val positions: List<Pair<Int, Int>>, val item: BoardItem) {

    /**
     * Colour: Orange
     *
     * Shape:
     * ```
     *   O O O
     *   O
     * ```
     */
    O_L_1(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(0, 1),
        ),
        BoardItem.ORANGE
    ),

    /**
     * Colour: Green
     *
     * Shape:
     * ```
     *   G G
     *     G G G
     * ```
     */
    G_L_1(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(1, 1),
            Pair(2, 1),
            Pair(3, 1),
        ),
        BoardItem.GREEN
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *   R R
     *   R R R
     * ```
     */
    R_P_1(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(2, 1),
        ),
        BoardItem.RED
    ),


    /**
     * Colour: CYAN
     *
     * Shape:
     * ```
     *   C C C
     *   C
     *   C
     * ```
     */
    C_L_1(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(0, 1),
            Pair(0, 2),
        ),
        BoardItem.CYAN
    ),


    /**
     * Colour: GREY
     *
     * Shape:
     * ```
     *     G
     *   G G G
     *     G
     * ```
     */
    G_T_1(
        listOf(
            Pair(1, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(2, 1),
            Pair(1, 2),
        ),
        BoardItem.PINK
    ),

    /**
     * Colour: Blue
     *
     * Shape:
     * ```
     *   B
     *   B
     *   B
     *   B B
     * ```
     */
    B_L_1(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(0, 3),
            Pair(1, 3),
        ),
        BoardItem.BLUE
    ),

    /**
     * Colour: Purple
     *
     * Shape:
     * ```
     *   P
     *   P
     *   P
     *   P
     * ```
     */
    P_I_1(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(0, 3),
        ),
        BoardItem.PURPLE
    ),


    /**
     * Colour: Pink
     *
     * Shape:
     * ```
     *   P
     *   P P
     *   P
     *   P
     * ```
     */
    P_K_1(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(0, 2),
            Pair(0, 3),
        ),
        BoardItem.WHITE
    ),

    /**
     * Colour: Magenta
     *
     * Shape:
     * ```
     *   M
     *   M M
     *     M M
     * ```
     */
    M_M_1(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(1, 2),
            Pair(2, 2),
        ),
        BoardItem.MAGENTA
    ),

    /**
     * Colour: Yellow
     *
     * Shape:
     * ```
     *   Y Y Y
     *   Y
     *   Y Y Y
     * ```
     */
    Y_C_1(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(1, 2),
            Pair(2, 2),
        ),
        BoardItem.YELLOW
    ),


    /**
     * Colour: Green
     *
     * Shape:
     * ```
     *   G G
     *   G G
     * ```
     */
    G_O_1(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(0, 1),
            Pair(1, 1),
        ),
        BoardItem.GREEN
    ),
}
