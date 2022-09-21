class QuickSort {

    fun sort(low: Int, high: Int, array: Array<Int>) {
        if (low < high) {
            val partitionIndex = partition(low, high, array)
            sort(low, partitionIndex - 1, array)
            sort(partitionIndex + 1, high, array)
        }
    }

    private fun partition(low: Int, high: Int, array: Array<Int>): Int {
        var leftPointer = low - 1
        val pivot = array[high]
        for (i in low until high) {
            if (array[i] <= pivot) {
                leftPointer++
                swap(array, i, leftPointer)
            }
        }
        swap(array, leftPointer + 1, high)
        return leftPointer + 1
    }

    private fun swap(array: Array<Int>, firstIndex: Int, secondIndex: Int) {
        val temp = array[firstIndex]
        array[firstIndex] = array[secondIndex]
        array[secondIndex] = temp
    }
}


fun main(args: Array<Int>) {
    val quickSort = QuickSort()
    val array = arrayOf(9, 8, 7, 6, 5)
    quickSort.sort(0, array.size - 1, array)
    for (element in array) {
        println(element)
    }
}