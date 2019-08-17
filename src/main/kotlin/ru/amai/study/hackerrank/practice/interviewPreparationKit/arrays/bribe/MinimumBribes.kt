package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.bribe

import java.util.*

fun minimumBribes(queue: IntArray): String =
    if (queue.withIndex().any { (indx, elem) -> (elem - (indx + 1)) > 2}) {
        "Too chaotic"
    } else {
        mergeSort(queue).toString()
    }

private fun mergeSort(arr: IntArray): Int =
    mergeSortSupport(arr, IntArray(arr.size), 0, arr.size)

private fun mergeSortSupport(arr: IntArray, temp: IntArray, left: Int, right: Int): Int =
    if (right - left > 1) {
        var inversionCnt: Int
        val mid = (right + left) / 2

        inversionCnt = mergeSortSupport(arr, temp, left, mid)
        inversionCnt += mergeSortSupport(arr, temp, mid, right)

        inversionCnt += merge(arr, temp, left, mid, right)

        inversionCnt
    } else 0

private fun merge(arr: IntArray, temp: IntArray, left: Int, mid: Int, right: Int): Int {
    var inversionCnt = 0

    var i: Int = left
    var j: Int = mid
    var k: Int = left
    while (i < mid && j < right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++]
        } else {
            temp[k++] = arr[j++]
            inversionCnt += (mid - i)
        }
    }

    (i until mid).forEach { temp[k++] = arr[it] }
    (j until right).forEach { temp[k++] = arr[it] }

    (left until right).forEach { arr[it] = temp[it] }

    return inversionCnt
}

fun main() {
    val scanner = Scanner(System.`in`)

    val casesCnt = scanner.nextLine().trim().toInt()

    for (tItr in 1..casesCnt) {
        scanner.nextLine().trim().toInt()
        val queue = scanner.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

        println(minimumBribes(queue))
    }
}
