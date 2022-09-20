class SortAlg {

    class SortAlg {
        fun readCount() {
            // Read Vote-Results.csv
        }

        fun sort() {
            // key part of the sorting algorithm
            // sort the records by VoteCount
        }

        operator fun get(rank: Int) {
            // get the rank record in the sorted results
            println("UserID xxx is ranked at rank with xxx votes")
        }

        companion object {
            @JvmStatic
            fun main(args: Array<String>) {
                println("Starter code!")
                val sortAlg = SortAlg()
                sortAlg.readCount()
                sortAlg.sort()

                // Test get() method
                sortAlg[1]
                sortAlg[5]
            }
        }
    }
}