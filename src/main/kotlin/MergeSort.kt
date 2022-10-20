fun mergeSort(list: List<CountedVotes>): List<CountedVotes> {
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    val left = list.subList(0,middle)
    val right = list.subList(middle,list.size)

    return merge(mergeSort(left), mergeSort(right))
}
fun merge(left: List<CountedVotes>, right: List<CountedVotes>): List<CountedVotes>  {
    var indexLeft = 0
    var indexRight = 0
    val newList : MutableList<CountedVotes> = mutableListOf()

    while (indexLeft < left.count() && indexRight < right.count()) {
        if (compare(left[indexLeft], right[indexRight]) <= 0){
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.size) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }
    return newList
}

val numbers = countedVotes
val sortedList = mergeSort(numbers)

fun getM(rank: Int) {
    val index = rank
    val rank = (mergeSort(countedVotes).toList()[index])
    println("UserID ${rank.candidate} is ranked at rank with ${rank.voteCount} votes")
}
fun main() {
    println("After Merge Sort: $sortedList")
    getM(0)
}

