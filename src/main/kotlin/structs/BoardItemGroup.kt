package structs

enum class BoardItemGroup(val positions: List<Pair<Int, Int>>, val item: BoardItem, val familyGroup: Int) {
    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *   O O O
     *   O
     * ```
     */
    O_L_0(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(0, 1)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *   O O
     *     O
     *     O
     * ```
     */
    O_L_1(
        listOf(
            Pair(1, 0),
            Pair(1, 1),
            Pair(1, 2),
            Pair(0, 0)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *       O
     *   O O O
     * ```
     */
    O_L_2(
        listOf(
            Pair(2, 1),
            Pair(1, 1),
            Pair(0, 1),
            Pair(2, 0)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *   O
     *   O
     *   O O
     * ```
     */
    O_L_3(
        listOf(
            Pair(0, 2),
            Pair(0, 1),
            Pair(0, 0),
            Pair(1, 2)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *   O O
     *   O
     *   O
     * ```
     */
    O_L_4(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(1, 0)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *   O O O
     *       O
     * ```
     */
    O_L_5(
        listOf(
            Pair(2, 0),
            Pair(1, 0),
            Pair(0, 0),
            Pair(2, 1)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *     O
     *     O
     *   O O
     * ```
     */
    O_L_6(
        listOf(
            Pair(1, 2),
            Pair(1, 1),
            Pair(1, 0),
            Pair(0, 2)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: ORANGE
     *
     * Shape:
     * ```
     *   O
     *   O O O
     * ```
     */
    O_L_7(
        listOf(
            Pair(0, 1),
            Pair(1, 1),
            Pair(2, 1),
            Pair(0, 0)
        ),
        BoardItem.ORANGE,
        0
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *   G G
     *     G G G
     * ```
     */
    G_L_0(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(1, 1),
            Pair(2, 1),
            Pair(3, 1)
        ),
        BoardItem.GREEN,
        1
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *     G
     *   G G
     *   G
     *   G
     * ```
     */
    G_L_1(
        listOf(
            Pair(1, 0),
            Pair(1, 1),
            Pair(0, 1),
            Pair(0, 2),
            Pair(0, 3)
        ),
        BoardItem.GREEN,
        1
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *   G G G
     *       G G
     * ```
     */
    G_L_2(
        listOf(
            Pair(3, 1),
            Pair(2, 1),
            Pair(2, 0),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.GREEN,
        1
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *     G
     *     G
     *   G G
     *   G
     * ```
     */
    G_L_3(
        listOf(
            Pair(0, 3),
            Pair(0, 2),
            Pair(1, 2),
            Pair(1, 1),
            Pair(1, 0)
        ),
        BoardItem.GREEN,
        1
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *   G
     *   G G
     *     G
     *     G
     * ```
     */
    G_L_4(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(1, 2),
            Pair(1, 3)
        ),
        BoardItem.GREEN,
        1
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *       G G
     *   G G G
     * ```
     */
    G_L_5(
        listOf(
            Pair(3, 0),
            Pair(2, 0),
            Pair(2, 1),
            Pair(1, 1),
            Pair(0, 1)
        ),
        BoardItem.GREEN,
        1
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *   G
     *   G
     *   G G
     *     G
     * ```
     */
    G_L_6(
        listOf(
            Pair(1, 3),
            Pair(1, 2),
            Pair(0, 2),
            Pair(0, 1),
            Pair(0, 0)
        ),
        BoardItem.GREEN,
        1
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *     G G G
     *   G G
     * ```
     */
    G_L_7(
        listOf(
            Pair(0, 1),
            Pair(1, 1),
            Pair(1, 0),
            Pair(2, 0),
            Pair(3, 0)
        ),
        BoardItem.GREEN,
        1
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
    R_P_0(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(2, 1)
        ),
        BoardItem.RED,
        2
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *   R R
     *   R R
     *   R
     * ```
     */
    R_P_1(
        listOf(
            Pair(1, 0),
            Pair(1, 1),
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2)
        ),
        BoardItem.RED,
        2
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *   R R R
     *     R R
     * ```
     */
    R_P_2(
        listOf(
            Pair(2, 1),
            Pair(1, 1),
            Pair(2, 0),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.RED,
        2
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *     R
     *   R R
     *   R R
     * ```
     */
    R_P_3(
        listOf(
            Pair(0, 2),
            Pair(0, 1),
            Pair(1, 2),
            Pair(1, 1),
            Pair(1, 0)
        ),
        BoardItem.RED,
        2
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *   R R
     *   R R
     *     R
     * ```
     */
    R_P_4(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(1, 0),
            Pair(1, 1),
            Pair(1, 2)
        ),
        BoardItem.RED,
        2
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *     R R
     *   R R R
     * ```
     */
    R_P_5(
        listOf(
            Pair(2, 0),
            Pair(1, 0),
            Pair(2, 1),
            Pair(1, 1),
            Pair(0, 1)
        ),
        BoardItem.RED,
        2
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *   R
     *   R R
     *   R R
     * ```
     */
    R_P_6(
        listOf(
            Pair(1, 2),
            Pair(1, 1),
            Pair(0, 2),
            Pair(0, 1),
            Pair(0, 0)
        ),
        BoardItem.RED,
        2
    ),

    /**
     * Colour: RED
     *
     * Shape:
     * ```
     *   R R R
     *   R R
     * ```
     */
    R_P_7(
        listOf(
            Pair(0, 1),
            Pair(1, 1),
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0)
        ),
        BoardItem.RED,
        2
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
    C_L_0(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(0, 1),
            Pair(0, 2)
        ),
        BoardItem.CYAN,
        3
    ),

    /**
     * Colour: CYAN
     *
     * Shape:
     * ```
     *   C C C
     *       C
     *       C
     * ```
     */
    C_L_1(
        listOf(
            Pair(2, 0),
            Pair(2, 1),
            Pair(2, 2),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.CYAN,
        3
    ),

    /**
     * Colour: CYAN
     *
     * Shape:
     * ```
     *       C
     *       C
     *   C C C
     * ```
     */
    C_L_2(
        listOf(
            Pair(2, 2),
            Pair(1, 2),
            Pair(0, 2),
            Pair(2, 1),
            Pair(2, 0)
        ),
        BoardItem.CYAN,
        3
    ),

    /**
     * Colour: CYAN
     *
     * Shape:
     * ```
     *   C
     *   C
     *   C C C
     * ```
     */
    C_L_3(
        listOf(
            Pair(0, 2),
            Pair(0, 1),
            Pair(0, 0),
            Pair(1, 2),
            Pair(2, 2)
        ),
        BoardItem.CYAN,
        3
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *     P
     *   P P P
     *     P
     * ```
     */
    G_T_0(
        listOf(
            Pair(1, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(2, 1),
            Pair(1, 2)
        ),
        BoardItem.PINK,
        4
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *   B
     *   B
     *   B
     *   B B
     * ```
     */
    B_L_0(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(0, 3),
            Pair(1, 3)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *   B B B B
     *   B
     * ```
     */
    B_L_1(
        listOf(
            Pair(3, 0),
            Pair(2, 0),
            Pair(1, 0),
            Pair(0, 0),
            Pair(0, 1)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *   B B
     *     B
     *     B
     *     B
     * ```
     */
    B_L_2(
        listOf(
            Pair(1, 3),
            Pair(1, 2),
            Pair(1, 1),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *         B
     *   B B B B
     * ```
     */
    B_L_3(
        listOf(
            Pair(0, 1),
            Pair(1, 1),
            Pair(2, 1),
            Pair(3, 1),
            Pair(3, 0)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *   B B B B
     *         B
     * ```
     */
    B_L_4(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(3, 0),
            Pair(3, 1)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *     B
     *     B
     *     B
     *   B B
     * ```
     */
    B_L_5(
        listOf(
            Pair(1, 0),
            Pair(1, 1),
            Pair(1, 2),
            Pair(1, 3),
            Pair(0, 3)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *   B
     *   B B B B
     * ```
     */
    B_L_6(
        listOf(
            Pair(3, 1),
            Pair(2, 1),
            Pair(1, 1),
            Pair(0, 1),
            Pair(0, 0)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: BLUE
     *
     * Shape:
     * ```
     *   B B
     *   B
     *   B
     *   B
     * ```
     */
    B_L_7(
        listOf(
            Pair(0, 3),
            Pair(0, 2),
            Pair(0, 1),
            Pair(0, 0),
            Pair(1, 0)
        ),
        BoardItem.BLUE,
        5
    ),

    /**
     * Colour: PURPLE
     *
     * Shape:
     * ```
     *   P
     *   P
     *   P
     *   P
     * ```
     */
    P_I_0(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(0, 3)
        ),
        BoardItem.PURPLE,
        6
    ),

    /**
     * Colour: PURPLE
     *
     * Shape:
     * ```
     *   P P P P
     * ```
     */
    P_I_1(
        listOf(
            Pair(3, 0),
            Pair(2, 0),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.PURPLE,
        6
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *   P
     *   P P
     *   P
     *   P
     * ```
     */
    P_K_0(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(0, 2),
            Pair(0, 3)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *   P P P P
     *       P
     * ```
     */
    P_K_1(
        listOf(
            Pair(3, 0),
            Pair(2, 0),
            Pair(2, 1),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *     P
     *     P
     *   P P
     *     P
     * ```
     */
    P_K_2(
        listOf(
            Pair(1, 3),
            Pair(1, 2),
            Pair(0, 2),
            Pair(1, 1),
            Pair(1, 0)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *     P
     *   P P P P
     * ```
     */
    P_K_3(
        listOf(
            Pair(0, 1),
            Pair(1, 1),
            Pair(1, 0),
            Pair(2, 1),
            Pair(3, 1)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *   P P P P
     *     P
     * ```
     */
    P_K_4(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(1, 1),
            Pair(2, 0),
            Pair(3, 0)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *     P
     *   P P
     *     P
     *     P
     * ```
     */
    P_K_5(
        listOf(
            Pair(1, 0),
            Pair(1, 1),
            Pair(0, 1),
            Pair(1, 2),
            Pair(1, 3)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *       P
     *   P P P P
     * ```
     */
    P_K_6(
        listOf(
            Pair(3, 1),
            Pair(2, 1),
            Pair(2, 0),
            Pair(1, 1),
            Pair(0, 1)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: PINK
     *
     * Shape:
     * ```
     *   P
     *   P
     *   P P
     *   P
     * ```
     */
    P_K_7(
        listOf(
            Pair(0, 3),
            Pair(0, 2),
            Pair(1, 2),
            Pair(0, 1),
            Pair(0, 0)
        ),
        BoardItem.PINK,
        7
    ),

    /**
     * Colour: MAGENTA
     *
     * Shape:
     * ```
     *   M
     *   M M
     *     M M
     * ```
     */
    M_M_0(
        listOf(
            Pair(0, 0),
            Pair(0, 1),
            Pair(1, 1),
            Pair(1, 2),
            Pair(2, 2)
        ),
        BoardItem.MAGENTA,
        8
    ),

    /**
     * Colour: MAGENTA
     *
     * Shape:
     * ```
     *     M M
     *   M M
     *   M
     * ```
     */
    M_M_1(
        listOf(
            Pair(2, 0),
            Pair(1, 0),
            Pair(1, 1),
            Pair(0, 1),
            Pair(0, 2)
        ),
        BoardItem.MAGENTA,
        8
    ),

    /**
     * Colour: MAGENTA
     *
     * Shape:
     * ```
     *   M M
     *     M M
     *       M
     * ```
     */
    M_M_2(
        listOf(
            Pair(2, 2),
            Pair(2, 1),
            Pair(1, 1),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.MAGENTA,
        8
    ),

    /**
     * Colour: MAGENTA
     *
     * Shape:
     * ```
     *       M
     *     M M
     *   M M
     * ```
     */
    M_M_3(
        listOf(
            Pair(0, 2),
            Pair(1, 2),
            Pair(1, 1),
            Pair(2, 1),
            Pair(2, 0)
        ),
        BoardItem.MAGENTA,
        8
    ),

    /**
     * Colour: YELLOW
     *
     * Shape:
     * ```
     *   Y Y Y
     *   Y
     *   Y Y Y
     * ```
     */
    Y_C_0(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(0, 1),
            Pair(0, 2),
            Pair(1, 2),
            Pair(2, 2)
        ),
        BoardItem.YELLOW,
        9
    ),

    /**
     * Colour: YELLOW
     *
     * Shape:
     * ```
     *   Y Y Y
     *   Y   Y
     *   Y   Y
     * ```
     */
    Y_C_1(
        listOf(
            Pair(2, 0),
            Pair(2, 1),
            Pair(2, 2),
            Pair(1, 0),
            Pair(0, 0),
            Pair(0, 1),
            Pair(0, 2)
        ),
        BoardItem.YELLOW,
        9
    ),

    /**
     * Colour: YELLOW
     *
     * Shape:
     * ```
     *   Y Y Y
     *       Y
     *   Y Y Y
     * ```
     */
    Y_C_2(
        listOf(
            Pair(2, 2),
            Pair(1, 2),
            Pair(0, 2),
            Pair(2, 1),
            Pair(2, 0),
            Pair(1, 0),
            Pair(0, 0)
        ),
        BoardItem.YELLOW,
        9
    ),

    /**
     * Colour: YELLOW
     *
     * Shape:
     * ```
     *   Y   Y
     *   Y   Y
     *   Y Y Y
     * ```
     */
    Y_C_3(
        listOf(
            Pair(0, 2),
            Pair(0, 1),
            Pair(0, 0),
            Pair(1, 2),
            Pair(2, 2),
            Pair(2, 1),
            Pair(2, 0)
        ),
        BoardItem.YELLOW,
        9
    ),

    /**
     * Colour: GREEN
     *
     * Shape:
     * ```
     *   G G
     *   G G
     * ```
     */
    G_O_0(
        listOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(0, 1),
            Pair(1, 1)
        ),
        BoardItem.GREEN,
        10
    ),

}