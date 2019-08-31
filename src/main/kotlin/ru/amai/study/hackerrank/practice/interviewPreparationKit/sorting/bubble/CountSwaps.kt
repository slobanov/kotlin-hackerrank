package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.bubble

import java.util.*

fun countSwaps(arr: Array<Int>): Int {
    var swapCnt = 0
    fun swap(i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp

        swapCnt += 1
    }

    val n = arr.size
    for (i in 0 until n) {
        for (j in 0 until n - 1) {
            if (arr[j] > arr[j + 1]) {
                swap(j, j + 1)
            }
        }
    }

    return swapCnt
}

fun main() {
    val scan = Scanner(System.`in`)
    scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    println("Array is sorted in ${countSwaps(arr)} swaps.")
    println("First Element: ${arr.first()}")
    println("Last Element: ${arr.last()}")
}
