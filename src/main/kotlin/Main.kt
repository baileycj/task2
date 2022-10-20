fun main() {
    //Read in Wiki-Vote.csv
    //Counts the votes for each candidate
    //Writes Vote-Result.csv
    countVotes()
    println()
    //Pre-Sorted Counted Votes
    println(countedVotes)

    //Merge Sort Vote-Result.csv
    println("Merge Sort")
    println(mergeSort(countedVotes))
    println()
    //Quick Sort Vote-Result.csv
    println("Quick Sort")
    println(quicksort(countMutableList))
    println()

    //Shell Sort Vote-Result.csv
    println("Shell Sort")
    println(shellSort(countMutableList))
    println()

    //Gets the highest voted candidate from the Merge Sort
    getM(1)
    println()

    //Gets the highest voted candidate from the Quick Sort
    getQS(1)
    println()

    //Gets the highest voted candidate from the Shell Sort
    getSS(1)
    println()
    println("Benchmark's")
    println("MergeSort Benchmark")
    benchMarkMS(10)
    println()
    println("QuickSort Benchmark")
    benchMarkQS(10)
    println()
    println("ShellSort Benchmark")
    benchMarkSS(10)
}