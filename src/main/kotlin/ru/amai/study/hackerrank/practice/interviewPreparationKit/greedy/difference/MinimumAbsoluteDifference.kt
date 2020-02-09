package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.difference

import java.util.*
import kotlin.math.abs

fun minimumAbsoluteDifference(arr: Array<Int>): Int =
    arr.sorted()
        .zipWithNext()
        .map { (a, b) -> abs(a - b) }
        .min()!!

fun main() {
    val scan = Scanner(System.`in`)
    scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = minimumAbsoluteDifference(arr)
    println(result)
}
