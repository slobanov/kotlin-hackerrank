package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.bribe

import ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.merge.mergeSortSupport
import java.util.*

fun minimumBribes(queue: IntArray): String =
    if (queue.withIndex().any { (indx, elem) -> (elem - (indx + 1)) > 2}) {
        "Too chaotic"
    } else {
        mergeSort(queue).toString()
    }

private fun mergeSort(arr: IntArray): Long =
    mergeSortSupport(arr, IntArray(arr.size), 0, arr.size)

fun main() {
    val scanner = Scanner(System.`in`)

    val casesCnt = scanner.nextLine().trim().toInt()

    for (tItr in 1..casesCnt) {
        scanner.nextLine().trim().toInt()
        val queue = scanner.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

        println(minimumBribes(queue))
    }
}
