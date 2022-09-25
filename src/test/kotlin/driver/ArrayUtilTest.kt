package driver

import drivers.ArrayUtil
import org.junit.jupiter.api.Assertions.assertArrayEquals
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

}