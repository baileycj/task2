

fun quicksort(items: MutableList<CountedVotes>): Collection<CountedVotes> {
    // Return if the input list is empty or only has 1 entry, since it's already sorted
    if (items.size <= 1) {
        return items
    }

    // Pick a pivot
    val chosenItem: CountedVotes = items[items.size / 2]

    // Partition items in three sets: smaller, equal and greater than chosen item
    val smallerList: MutableList<CountedVotes> = mutableListOf()
    val equalList: MutableList<CountedVotes> = mutableListOf()
    val greaterList: MutableList<CountedVotes> = mutableListOf()
    items.forEach {
        when {
            compare(chosenItem, it) > compare(it, chosenItem) -> smallerList.add(it)
            compare(chosenItem, it) < compare(it, chosenItem) -> greaterList.add(it)
            else -> equalList.add(it)
        }
    }

    // Combine results and return
    val sortedList: MutableList<CountedVotes> = mutableListOf()
    sortedList.addAll(quicksort(smallerList)) // Recursive call
    sortedList.addAll(equalList)
    sortedList.addAll(quicksort(greaterList)) // Recursive call
    return sortedList
}

fun getQS(rank: Int) {
    val index = rank
    val rank = (quicksort(countMutableList).toList()[index])
    println("UserID ${rank.candidate} is ranked at rank with ${rank.voteCount} votes")
}
fun main() {
    // Quick Sort the list and print it
    quicksort(countMutableList)
    getQS(0)
    println(sortedList)
}

