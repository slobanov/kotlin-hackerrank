package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.merge

import java.util.*

fun countInversions(arr: IntArray): Long =
    mergeSortSupport(arr, IntArray(arr.size), 0, arr.size)

fun mergeSortSupport(arr: IntArray, temp: IntArray, left: Int, right: Int): Long =
    if (right - left > 1) {
        var inversionCnt: Long
        val mid = (right + left) / 2

        inversionCnt = mergeSortSupport(arr, temp, left, mid)
        inversionCnt += mergeSortSupport(arr, temp, mid, right)

        inversionCnt += merge(arr, temp, left, mid, right)

        inversionCnt
    } else 0L

fun merge(arr: IntArray, temp: IntArray, left: Int, mid: Int, right: Int): Long {
    var inversionCnt = 0L

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
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        scan.nextLine().trim().toInt()
        val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

        val result = countInversions(arr)
        println(result)
    }
}
