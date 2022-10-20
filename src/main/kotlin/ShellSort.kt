import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

fun shellSort(arr: MutableList<CountedVotes>): MutableList<CountedVotes> {

    val n = arr.size

    var gap = n / 2
    while (gap > 0) {

        var i = gap
        while (i < n) {

            val temp = arr[i]

            var j = i
            while (j >= gap && compare(arr[j - gap], temp) > compare(temp, arr[j])) {
                arr[j] = arr[j - gap]
                j -= gap
            }

            arr[j] = temp
            i += 1
        }
        gap /= 2
    }
    return countMutableList
}


fun getSS(rank: Int) {
    val index = rank
    val rank = (shellSort(countMutableList))[index-1]
    println("UserID ${rank.candidate} is ranked at rank with ${rank.voteCount} votes")
}



fun main() {
    shellSort(countMutableList)
    println("Array after Shell sorting")
    println(countMutableList)
    getSS(1)
}

@OptIn(ExperimentalTime::class)
fun benchMarkSS(times: Int){
    repeat(times){
        val (value, duration) = measureTimedValue { shellSort(countMutableList) }
        println("It has taken ${duration.toDouble(DurationUnit.MILLISECONDS)}ms to Sort")
    }
}