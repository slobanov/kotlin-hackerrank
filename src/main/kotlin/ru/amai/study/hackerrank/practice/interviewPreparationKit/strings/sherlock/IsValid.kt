package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.sherlock

import java.util.*

fun isValid(string: String): String {
    val charFrequencyCounts: Map<Int, Int> = string.toList()
        .frequency()
        .values
        .frequency()

    return when (charFrequencyCounts.size) {
        1 -> true
        2 -> {
            val (smallCount, largeCount) = charFrequencyCounts.keys.sorted()
            val canRemoveLarge =
                ((largeCount - smallCount) == 1) && (charFrequencyCounts[largeCount] == 1)
            val canRemoveSmall =
                (smallCount == 1) && (charFrequencyCounts[smallCount] == 1)
            (canRemoveLarge) || (canRemoveSmall)
        }
        else -> false
    }.asYesOrNo()
}

private fun Boolean.asYesOrNo() = when (this) {
    true -> "YES"
    false -> "NO"
}

private fun <T> Iterable<T>.frequency(): Map<T, Int> = groupingBy { it }.eachCount()

fun main() {
    val scan = Scanner(System.`in`)
    val string = scan.nextLine()
    println(isValid(string))
}
