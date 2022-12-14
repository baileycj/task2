
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

fun quicksort(list: MutableList<CountedVotes>): Collection<CountedVotes> {
    // Return if the input list is empty or only has 1 entry, since it's already sorted
    if (list.size <= 1) {
        return list
    }

    // Pick a pivot
    val chosenItem: CountedVotes = list[list.size / 2]

    // Partition items in three sets: smaller, equal and greater than chosen item
    val smallerList: MutableList<CountedVotes> = mutableListOf()
    val equalList: MutableList<CountedVotes> = mutableListOf()
    val greaterList: MutableList<CountedVotes> = mutableListOf()
    list.forEach {
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
    val rank = (quicksort(countMutableList).toList()[index-1])
    println("UserID ${rank.candidate} is ranked at rank with ${rank.voteCount} votes")
}

fun main() {
    //Quick Sort the list and print it
    quicksort(countMutableList)
    //get the highest voted candidate after quick sorting.
    getQS(1)
    //println(sortedList)
    benchMarkQS(10)
}

@OptIn(ExperimentalTime::class)
fun benchMarkQS(times: Int){
    repeat(times){
        val (value, duration) = measureTimedValue { quicksort(countMutableList) }
        println("It has taken ${duration.toDouble(DurationUnit.MILLISECONDS)}ms to Sort")
    }
}