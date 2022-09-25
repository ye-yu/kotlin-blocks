package driver

import drivers.ArrayUtil
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArrayUtilTest {

    @Test
    fun transposeTest() {
        val output = listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        )
        val expected = listOf(
            listOf(1, 3, 5),
            listOf(2, 4, 6),
        )

        val actual = ArrayUtil.transpose(output)

        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun rotateTest() {
        val output = listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        )
        val expected = listOf(
            listOf(2, 4, 6),
            listOf(1, 3, 5),
        )

        val actual = ArrayUtil.rotate(output)

        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun flipTest() {
        val output = listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        )
        val expected = listOf(
            listOf(2, 1),
            listOf(4, 3),
            listOf(6, 5),
        )

        val actual = ArrayUtil.horizontalFlip(output)

        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun hasCombinationTest() {
        val combinationPool = listOf(
            listOf(
                listOf(0, 1),
                listOf(2, 1),
            ),
            listOf(
                listOf(8, 9),
                listOf(2, 1),
            ),
        )

        val availableCombination = listOf(
            listOf(0, 1),
            listOf(2, 1),
        )

        val nonExistentCombination = listOf(
            listOf(0, 1),
            listOf(2, 0),
        )

        val nonExistentCombination2 = listOf(
            listOf(4, 3),
            listOf(0, 0),
        )

        assertTrue(ArrayUtil.hasCombinationGroup(combinationPool, availableCombination))
        assertFalse(ArrayUtil.hasCombinationGroup(combinationPool, nonExistentCombination))
        assertFalse(ArrayUtil.hasCombinationGroup(combinationPool, nonExistentCombination2))
    }

    @Test
    fun hasCoordinatesTest() {
        val combinationPool = listOf(
            listOf(
                Pair(0, 1),
                Pair(2, 1),
            ),
            listOf(
                Pair(8, 9),
                Pair(2, 1),
            ),
        )

        val availableCombination = listOf(
            Pair(0, 1),
            Pair(2, 1),
        )

        val nonExistentCombination = listOf(
            Pair(0, 1),
            Pair(2, 0),
        )

        val nonExistentCombination2 = listOf(
            Pair(4, 3),
            Pair(0, 0),
        )

        assertTrue(ArrayUtil.hasCoordinatesGroup(combinationPool, availableCombination))
        assertFalse(ArrayUtil.hasCoordinatesGroup(combinationPool, nonExistentCombination))
        assertFalse(ArrayUtil.hasCoordinatesGroup(combinationPool, nonExistentCombination2))
    }

}