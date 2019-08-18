package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.manipulation

import java.lang.Long.max
import java.util.*

fun arrayManipulation(n: Int, queries: Array<IntArray>): Long {
    val array = Array(n) { 0L }
    queries.forEach { (a, b, k) ->
        array[a-1] = array[a-1] + k
        if (b < n) {
            array[b] = array[b] - k
        }
    }

    var currentSum = 0L
    var maxSum = 0L
    array.forEach {
        currentSum += it
        maxSum = max(maxSum, currentSum)
    }
    return maxSum
}

private const val OP_SIZE = 3

fun main() {
    val scanner = Scanner(System.`in`)

    val nm = scanner.nextLine().split(" ")
    val n = nm[0].trim().toInt()
    val m = nm[1].trim().toInt()

    val queries = Array(m) { IntArray(OP_SIZE) }
    for (i in 0 until m) {
        queries[i] = scanner.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
    }

    val result = arrayManipulation(n, queries)
    println(result)
}
