package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.rotation

import java.util.*

fun rotLeft(arr: Array<Int>, d: Int): Array<Int> {
    val size = arr.size
    fun shiftedIndex(indx: Int) = ((indx - d) % size + size) % size
    val newIndexedElems = arr
        .mapIndexed { indx, elem -> shiftedIndex(indx) to elem }
        .toMap()

    return (0 until size).map(newIndexedElems::getValue).toTypedArray()
}

fun main() {
    val scanner = Scanner(System.`in`)
    val nd = scanner.nextLine().split(" ")
    val d = nd[1].trim().toInt()
    val arr = scanner.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = rotLeft(arr, d)
    println(result.joinToString(" "))
}
