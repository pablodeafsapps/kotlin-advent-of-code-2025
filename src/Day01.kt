
fun main() {
    fun part1(input: List<String>): Int {
        var dial = 50
        var count = 0
        input.forEach { line ->
            val direction = line[0]
            val amount = line.drop(1)
            if (direction == 'R') {
                dial += amount.toInt()
            } else {
                dial -= amount.toInt()
            }
            when {
                dial >= 0 -> dial %= 100
                else -> dial += (-dial/100) * 100
            }
            if (dial == 0) count++
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var dial = 50
        var count = 0
        input.forEach { line ->
            val direction = line[0]
            val amount = line.drop(1)
            repeat(amount.toInt()) {
                dial += if (direction == 'R') {
                    1
                } else {
                    -1
                }
                dial %= 100
                if (dial == 0) count++
            }
        }
        return count
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
//    val input = readInput("Day01_test")
//    part1(input).println()
    part2(input).println()
}
