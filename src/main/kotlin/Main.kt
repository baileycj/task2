const val Data_Set_DIR = "./dataset/"
fun main() {
    //Read in Wiki-Vote.csv
    //Counts the votes for each candidate
    //Writes Vote-Result.csv
    countVotes()
    println()
    //Pre-Sorted Counted Votes
    println(countedVotes)
    println("Merge Sort")

    println(mergeSort(countedVotes))
    println()
    println("Quick Sort")
    println(quicksort(countMutableList))
    println()
    println("Shell Sort")
    println(shellSort(countMutableList))
    println()
    println()
    getM(0)
    println()
    getQS(0)
    println()
    getSS(0)


}