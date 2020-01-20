package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.toys

import java.util.*

fun maximumToys(prices: Array<Int>, sum: Int): Int =
    prices.sortedArray()
        .fold(mutableListOf<Int>()) { lst, elem ->
            lst.apply { add((lst.lastOrNull() ?: 0) + elem) }
        }.takeWhile { it <= sum }
        .size

fun main() {
    val scanner = Scanner(System.`in`)

    val nk = scanner.nextLine().split(" ")
    val k = nk[1].trim().toInt()
    val prices = scanner.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = maximumToys(prices, k)
    println(result)
}
