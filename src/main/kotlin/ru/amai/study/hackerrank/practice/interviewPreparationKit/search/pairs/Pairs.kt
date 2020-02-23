package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.pairs

import java.util.*

fun pairs(k: Int, arr: Array<Int>): Int {
    require(k > 0) { "k should be > 0; got $k" }

    val valueCount = arr
        .groupingBy { it }
        .eachCount()

    return arr.sumBy { v -> valueCount[v - k] ?: 0 }
}

fun main() {
    val scan = Scanner(System.`in`)

    val (_, k) = scan.nextLine().trim().split(" ").map { it.trim().toInt() }
    val arr = scan.nextLine().trim().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = pairs(k, arr)
    println(result)
}
