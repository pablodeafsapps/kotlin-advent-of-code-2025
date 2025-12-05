
fun main() {
    fun part1(input: List<String>): Int {
        var rollsAccessible = 0
        for (row in 0 until input.size) {
            for (col in 0 until input[0].length) {
                if (input[row][col] != '@') continue
                var localCount = 0
                val prevRow = row - 1; val nextRow = row + 1
                val prevCol = col - 1; val nextCol = col + 1
                if (input.getOrNull(prevRow)?.getOrNull(prevCol) == '@') localCount++
                if (input.getOrNull(prevRow)?.getOrNull(col) == '@') localCount++
                if (input.getOrNull(prevRow)?.getOrNull(nextCol) == '@') localCount++
                if (input.getOrNull(row)?.getOrNull(prevCol) == '@')
                    (++localCount).also { lc -> if (lc > 3) continue }
                if (input.getOrNull(row)?.getOrNull(nextCol) == '@')
                    (++localCount).also { lc -> if (lc > 3) continue }
                if (input.getOrNull(nextRow)?.getOrNull(prevCol) == '@')
                    (++localCount).also { lc -> if (lc > 3) continue }
                if (input.getOrNull(nextRow)?.getOrNull(col) == '@')
                    (++localCount).also { lc -> if (lc > 3) continue }
                if (input.getOrNull(nextRow)?.getOrNull(nextCol) == '@')
                    (++localCount).also { lc -> if (lc > 3) continue }

                rollsAccessible++
            }
        }
        return rollsAccessible
    }

    fun part2(input: List<String>): Int {
        val grid = input.toMutableList()
        var rollsRemoved = 0
        var rollsRemovable = 0
        do {
            rollsRemovable = 0
            for (row in 0 until grid.size) {
                for (col in 0 until grid[0].length) {
                    if (grid[row][col] != '@') continue
                    var localCount = 0
                    val prevRow = row - 1; val nextRow = row + 1
                    val prevCol = col - 1; val nextCol = col + 1
                    if (grid.getOrNull(prevRow)?.getOrNull(prevCol) == '@') localCount++
                    if (grid.getOrNull(prevRow)?.getOrNull(col) == '@') localCount++
                    if (grid.getOrNull(prevRow)?.getOrNull(nextCol) == '@') localCount++
                    if (grid.getOrNull(row)?.getOrNull(prevCol) == '@')
                        (++localCount).also { lc -> if (lc > 3) continue }
                    if (grid.getOrNull(row)?.getOrNull(nextCol) == '@')
                        (++localCount).also { lc -> if (lc > 3) continue }
                    if (grid.getOrNull(nextRow)?.getOrNull(prevCol) == '@')
                        (++localCount).also { lc -> if (lc > 3) continue }
                    if (grid.getOrNull(nextRow)?.getOrNull(col) == '@')
                        (++localCount).also { lc -> if (lc > 3) continue }
                    if (grid.getOrNull(nextRow)?.getOrNull(nextCol) == '@')
                        (++localCount).also { lc -> if (lc > 3) continue }

                    val updatedLine = grid[row].substring(0 until col) +
                            "X" +
                            grid[row].substring(col + 1 until grid[row].length)
                    grid[row] = updatedLine
                    rollsRemovable++
                }
            }
            rollsRemoved += rollsRemovable
        } while (rollsRemovable > 0)
        return rollsRemoved
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day04_test.txt` file:
//    val testInput = readInput("Day04_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day04.txt` file.
    val input = readInput("Day04")
//    val input = readInput("Day04_test")
//    part1(input).println()
    part2(input).println()
}
