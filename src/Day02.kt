
fun main() {
    fun part1(input: List<String>): Long {
        val idRanges = input[0].split(",")
        val sumInvalidIds = mutableListOf<Long>()
        idRanges.forEach { range ->
            val (start, end) = """(\d+)-(\d+)""".toRegex().find(range)!!.groupValues.mapNotNull { it.toLongOrNull() }
            var curr = start
            while (curr <= end) {
                if (curr.toString().length % 2 == 0) {
                    val idString = curr.toString()
                    val length = curr.toString().length
                    val first = idString.take(length/2)
                    val second = idString.substring(startIndex = length/2, endIndex = length)
                    if (first == second) sumInvalidIds.add(curr)
                }
                curr++
            }
        }
        return sumInvalidIds.sum()
    }

    fun part2(input: List<String>): Long {
        val idRanges = input[0].split(",")
        val sumInvalidIds = mutableListOf<Long>()
        idRanges.forEach { range ->
            val (start, end) = """(\d+)-(\d+)""".toRegex().find(range)!!.groupValues.mapNotNull { it.toLongOrNull() }
            var curr = start
            while (curr <= end) {
                val idString = curr.toString()
                val length = curr.toString().length
                for (window in 1 .. length/2) {
                    if (length % window != 0) continue
                    val windowFit = length / window
                    val distinctSet = mutableSetOf<Long>()
                    repeat(windowFit) { idx ->
                        distinctSet.add(
                            idString.substring(startIndex = idx * window, endIndex = window * (idx + 1)).toLong()
                        )
                    }
                    if (distinctSet.size == 1) {
                        sumInvalidIds.add(curr)
                        break
                    }
                }
                curr++
            }
        }
        println(sumInvalidIds)
        return sumInvalidIds.sum()
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day02_test.txt` file:
//    val testInput = readInput("Day02_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
//    val input = readInput("Day02_test")
//    part1(input).println()
    part2(input).println()
}
