package drivers

import structs.FixedSizeArray

object FixedSizeArrayUtil {
    fun <T> put(array: FixedSizeArray<T>, item: T) {
        array.items[array.nextPointer] = item
        array.nextPointer = (array.nextPointer + 1) % array.items.size
    }

    fun <T> new(size: Int): FixedSizeArray<T> {
        return FixedSizeArray<T>().apply {
            for (i in 0 until size) {
                this.items += null
            }
        }
    }

    inline fun <reified T> filterNonNull(array: FixedSizeArray<T>): Array<T> {
        return array.items.filterNotNull().toTypedArray()
    }
}