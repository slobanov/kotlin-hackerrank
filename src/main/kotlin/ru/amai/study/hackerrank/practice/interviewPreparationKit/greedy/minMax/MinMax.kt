package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.minMax

import java.util.*

fun maxMin(k: Int, arr: IntArray): Int {
    val sortedArr = arr.sorted()
    return (0..arr.size - k).map { i ->
        sortedArr[i + k - 1] - sortedArr[i]
    }.min()!!
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()
    val k = scan.nextLine().trim().toInt()
    val arr = (1..n).map { scan.nextLine().trim().toInt() }.toIntArray()

    val result = maxMin(k, arr)
    println(result)
}
