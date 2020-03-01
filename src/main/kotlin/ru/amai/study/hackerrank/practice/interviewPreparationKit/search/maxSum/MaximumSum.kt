package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.maxSum

import java.util.*
import kotlin.math.max

fun maximumSum(list: List<Long>, divisor: Long): Long {
    val prefixSums = TreeSet<Long>()

    var maxSum = 0L
    var prefix = 0L
    for (elem in list) {
        prefix = (prefix + elem) % divisor
        maxSum = max(maxSum, prefix)

        prefixSums.ceiling(prefix + 1)?.let {
            maxSum = max(maxSum, (prefix - it + divisor) % divisor)
        }

        prefixSums += prefix
    }

    return maxSum
}

fun main() {
    val scan = Scanner(System.`in`)

    val queriesCnt = scan.nextLine().trim().toInt()

    fun readLongList() = scan.nextLine().split(" ").map { it.trim().toLong() }

    repeat(queriesCnt) {
        val (_, divisor) = readLongList()
        val array = readLongList()

        val result = maximumSum(array, divisor)
        println(result)
    }
}
