package drivers

object ArrayUtil {
    fun <T> rotate(arr: List<List<T>>): List<List<T>> {
        if (arr.isEmpty()) return arr
        arr.checkShape()
        return arr.map {
            it.reversed()
        }.transpose()
    }

    fun <T> transpose(arr: List<List<T>>): List<List<T>> {
        if (arr.isEmpty()) return arr
        arr.checkShape()
        return arr.transpose()
    }

    fun <T> horizontalFlip(arr: List<List<T>>): List<List<T>> {
        if (arr.isEmpty()) return arr
        arr.checkShape()
        val innerSize = arr[0].size
        val outerSize = arr.size

        return List(outerSize) { outer ->
            List(innerSize) { inner ->
                arr[outer][innerSize - inner - 1]
            }
        }
    }
}

private fun <E> List<List<E>>.checkShape() {
    check(this.foldRightIndexed(true) { i, _, acc -> if (i == 0) acc else this[i].size == this[i - 1].size }) {
        "Array must be the same size."
    }
}

private fun <E> List<List<E>>.transpose(): List<List<E>> {
    val innerSize = this[0].size
    val outerSize = this.size
    return List(innerSize) { outer ->
        List(outerSize) { inner ->
            this[inner][outer]
        }
    }
}
