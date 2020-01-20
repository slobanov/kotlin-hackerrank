package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.sock

import java.util.*

fun sockMerchant(socksColors: Array<Int>): Int =
    socksColors
        .groupingBy { it }
        .eachCount()
        .values
        .sumBy { sameColorCount -> sameColorCount / 2 }

fun main() {
    val scanner = Scanner(System.`in`)
    scanner.nextLine().trim().toInt()
    val socksColors = scanner.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(socksColors)
    println(result)
}
