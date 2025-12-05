
fun main() {
    fun part1(input: List<String>): Int {
        val joltageAcc = mutableListOf<Int>()
        for (bank in input) {
            val bankInt = bank.map { c -> c.digitToInt() }
            val bankIntFirstPortion = bankInt.subList(fromIndex = 0, toIndex = bankInt.size - 1)
            val maxIdx = bankIntFirstPortion.indexOfFirst { it == bankIntFirstPortion.max() }
            val bankIntLastPortion = bankInt.subList(fromIndex = maxIdx + 1, toIndex = bankInt.size)
            val min = bankIntLastPortion.max()

            val joltage = "${bankInt[maxIdx]}$min".toInt()
            joltageAcc.add(joltage)
        }
        return joltageAcc.sum()
    }

    fun part2(input: List<String>): Long {
        val joltageAcc = mutableListOf<Long>()
        for (bank in input) {
            val bankInt = bank.map { c -> c.digitToInt() }
            var lastIdx = -1
            val joltageBank = StringBuilder()
            for (iter in 0 until 12) {
                val startIdx = lastIdx + 1
                val toIdx = bankInt.size - 11 + iter
                val bankIntPortion = bankInt.subList(fromIndex = lastIdx + 1, toIndex = bankInt.size - 11 + iter)
                val maxIdx = bankIntPortion.indexOfFirst { it == bankIntPortion.max() }
                joltageBank.append(bankIntPortion[maxIdx])
                lastIdx += 1 + maxIdx
            }
            joltageAcc.add(joltageBank.toString().toLong()  )
        }
        return joltageAcc.sum()
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day03_test.txt` file:
//    val testInput = readInput("Day03_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
//    val input = readInput("Day03_test")
//    part1(input).println()
    part2(input).println()
}
