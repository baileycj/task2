import java.io.File
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

fun OutputStream.writeCsv(votes: List<Vote>) {
    val writer = bufferedWriter()
    writer.write(""""VoteCaster", "VoteReceiver"""")
    writer.newLine()
    votes.forEach {
        writer.write("${it.voteFrom}, ${it.voteTo}")
        writer.newLine()
    }
    writer.flush()
}

val votes_array: Array<Vote> = votes.toTypedArray()


fun countVotes(){

}

