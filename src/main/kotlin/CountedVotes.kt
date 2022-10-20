import java.io.File
import java.io.InputStream

data class CountedVotes(
    val candidate: Int,
    val voteCount: Int,
)
fun readCount(): List<CountedVotes> {
    val inputStream: InputStream = File("./dataset/Vote-Results.csv").inputStream()
    val reader = inputStream.bufferedReader()
    val header = reader.readLine()
    return reader.lineSequence().filter { it.isNotBlank() }
        .map {
            val (candidate, voteCount) = it.split(',')
            CountedVotes(candidate.trim().toInt(), voteCount.trim().toInt())
        }.toList()
}

val countedVotes = readCount(/*Open a stream to CSV file*/)

//Compares voteCount to see which count is larger and returns 0 for equal, 1 for larger -1 if it is smaller.
fun compare(countedVotes: CountedVotes, countedVotes1: CountedVotes): Int {
    if (countedVotes.voteCount == countedVotes1.voteCount){
        return 0
    }
    return if (countedVotes.voteCount < countedVotes1.voteCount){
        1
    }else -1
}

val countMutableList: MutableList<CountedVotes> = countedVotes.toMutableList()