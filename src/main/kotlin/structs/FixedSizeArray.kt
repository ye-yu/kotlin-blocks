package structs

class FixedSizeArray<T> {
    var nextPointer = 0
    val items: MutableList<T?> = mutableListOf()
}