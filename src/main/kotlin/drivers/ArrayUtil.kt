package drivers

object ArrayUtil {

    fun <T> rotate(arr: List<List<T>>): List<List<T>> {
        if (arr.isEmpty()) return arr
        arr.checkShape()
        return arr.map {
            it.reversed()
        }.transpose()
    }

    fun rotateCoords(arr: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        val rotated = arr.map {
            Pair(-it.second, it.first)
        }

        val minX = rotated.foldRight(0) { it, acc -> acc.coerceAtMost(it.first) }
        val minY = rotated.foldRight(0) { it, acc -> acc.coerceAtMost(it.second) }

        return rotated.map {
            Pair(it.first - minX, it.second - minY)
        }
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

    fun <T> pairFlip(arr: List<Pair<T, T>>): List<Pair<T, T>> {
        return arr.map {
            Pair(it.second, it.first)
        }
    }

    fun <T> hasCombinationGroup(source: List<List<List<T>>>, combinations: List<List<T>>): Boolean {
        return source.hasCombinationGroup(combinations)
    }

    fun <T> hasCoordinatesGroup(source: List<List<Pair<T, T>>>, combinations: List<Pair<T, T>>): Boolean {
        return source.hasCoordinatesGroup(combinations)
    }

    fun <T> anyIndexed(list: Iterator<T>, indexMapper: (Int, T) -> Boolean): Boolean {
        for ((i, v) in list.withIndex()) {
            if (indexMapper(i, v)) return true
        }
        return false
    }

}

private fun <E> List<List<Pair<E, E>>>.hasCoordinatesGroup(combinations: List<Pair<E, E>>): Boolean {
    return this.any { combination ->
        combination.map { es ->
            combinations.any { it.first == es.first && it.second == es.second }
        }.all { it }
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

private fun <E> List<List<List<E>>>.hasCombinationGroup(positions: List<List<E>>): Boolean {
    return this.any { combination ->
        combination.mapIndexed { index, es ->
            if (index < positions.size) positions[index] == es else false
        }.all { it }
    }
}

