package ru.amai.study.hackerrank.practice.interviewPreparationKit.dynamic.maxSubsetSum

import java.util.*
import kotlin.math.max

fun maxSubsetSum(array: Array<Int>): Int {

    val size = array.size
    val subMaxSums = Array(size) { 0 }
    subMaxSums[0] = array[0]
    subMaxSums[1] = max(array[0], array[1])

    (2 until size).forEach { i ->
        subMaxSums[i] = listOf(
            array[i],
            subMaxSums[i - 1],
            subMaxSums[i - 2] + array[i]
        ).max()!!
    }

    return subMaxSums.last()
}

fun main() {
    val scan = Scanner(System.`in`)

    scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = maxSubsetSum(arr)
    println(res)
}
