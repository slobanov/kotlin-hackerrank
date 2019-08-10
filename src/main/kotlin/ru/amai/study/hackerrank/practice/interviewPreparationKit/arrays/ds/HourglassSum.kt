package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.ds

import java.util.*
import java.util.Arrays.deepToString

private const val ARR_SIZE = 6

fun hourglassSum(arr: Array<Array<Int>>): Int {
    require(arr.size == ARR_SIZE && arr.all { row -> row.size == ARR_SIZE }) {
        "arr should be 2D $ARR_SIZE x $ARR_SIZE; got ${deepToString(arr)}"
    }

    fun singleHourglassSum(i: Int, j: Int) =
        arr[i][j]   + arr[i][j+1]   + arr[i][j+2] +
                      arr[i+1][j+1] +
        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]

    return (0 until ARR_SIZE-2)
        .flatMap { i -> (0 until ARR_SIZE-2).map {j -> i to j} }
        .map { (i, j) -> singleHourglassSum(i, j) }
        .max()!!
}

fun main() {
    val scanner = Scanner(System.`in`)
    val arr = Array(ARR_SIZE) { Array(ARR_SIZE) { 0 } }
    for (i in 0 until ARR_SIZE) {
        arr[i] = scanner.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)
    println(result)
}
