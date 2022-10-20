import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
data class Vote(
    val voteFrom: Int,
    val voteTo: Int,
)
fun readCsv(): List<Vote> {
    val inputStream: InputStream = File("./dataset/Wiki-Vote.csv").inputStream()
    val reader = inputStream.bufferedReader()
    val header = reader.readLine()
    return reader.lineSequence().filter { it.isNotBlank() }
        .map {
            val (voteFrom, voteTo) = it.split(',')
            Vote(voteFrom.trim().toInt(), voteTo.trim().toInt())
        }.toList()
}
val votes = readCsv(/*Open a stream to CSV file*/)

fun OutputStream.writeCsv(entries: List<String>) {
    val writer = bufferedWriter()
    writer.write("""Candidate, VoteCount""")
    writer.newLine()
    writer.newLine()
    entries.forEach {
        writer.write(it)
        writer.newLine()
    }
    writer.flush()
}
fun countVotes() {
    //groups who have been voted for, counts each time they have been voted for.
    val tally = votes.groupingBy { it.voteTo }.eachCount()
    //changes the map of vote counts to a list
    val voteResults: List<String> = tally.toList().map { "${it.first}, ${it.second}" }
    //writes the candidate and their vote count to csv.
    FileOutputStream("./dataset/Vote-Results.csv").apply { writeCsv(voteResults) }
}