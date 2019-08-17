package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.swap

import java.util.*

fun minimumSwaps(array: IntArray): Int {
    val visited = mutableSetOf<Int>()

    fun nextCycleLength(start: Int): Int {
        var current = start
        var cycleLength = 0
        do {
            visited += current
            cycleLength += 1
            current = array[current]-1
        } while (current != start)

        return cycleLength
    }

    return array.indices.asSequence()
        .filter { it !in visited }
        .sumBy { nextCycleLength(it) - 1 }
}

fun main() {
    val scanner = Scanner(System.`in`)
    scanner.nextLine().trim().toInt()
    val array = scanner.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

    val res = minimumSwaps(array)
    println(res)
}
