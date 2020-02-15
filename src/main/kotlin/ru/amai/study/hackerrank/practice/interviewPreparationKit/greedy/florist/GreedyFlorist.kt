package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.florist

import java.util.*

fun getMinimumCost(friendsCnt: Int, originalPrices: List<Int>): Int =
    originalPrices.sortedDescending()
        .chunked(friendsCnt)
        .withIndex()
        .sumBy { (index, prices) ->
            (1 + index) * prices.sum()
        }

fun main() {
    val scan = Scanner(System.`in`)

    val (_, friendsCnt) = scan.nextLine().split(" ").map { it.toInt() }
    val originalPrices = scan.nextLine().split(" ").map { it.trim().toInt() }.toList()

    val minimumCost = getMinimumCost(friendsCnt, originalPrices)
    println(minimumCost)
}
