package ru.amai.study.hackerrank.practice.interviewPreparationKit.dynamic.candies

import java.util.*
import kotlin.math.max
import kotlin.math.min

fun candies(grades: Array<Int>): Long {
    val size = grades.size

    val gradeByIndex = saveGrading(grades)

    val startIndicesWithDirections = buildStartIndicesWithDirections(gradeByIndex, size)
    val stopIndicesSet = buildStopIndicesSet(gradeByIndex, size)

    fun canMove(index: Int, direction: Direction): Boolean = when (direction) {
        Direction.LEFT -> index > 0
        Direction.RIGHT -> index < size - 1
    }

    val candiesDistribution = Array(size) { 1 }
    fun expandFrom(startIndex: Int, direction: Direction) {
        var currentIndx = startIndex
        while (currentIndx !in stopIndicesSet && canMove(currentIndx, direction)) {
            val currentCandies = candiesDistribution[currentIndx]
            currentIndx = direction.next(currentIndx)
            candiesDistribution[currentIndx] = max(currentCandies + 1, candiesDistribution[currentIndx])
        }
    }

    startIndicesWithDirections.forEach { (startIndex, directions) ->
        directions.forEach { direction -> expandFrom(startIndex, direction) }
    }

    return candiesDistribution.fold(0L) { acc, i -> acc + i }
}

private fun saveGrading(grades: Array<Int>): (Int) -> Int = { index -> when {
    index < 0 -> Int.MAX_VALUE
    index >= grades.size -> Int.MAX_VALUE
    else -> grades[index]
} }

private fun buildStartIndicesWithDirections(gradeByIndex: (Int) -> Int, size: Int): List<Pair<Int, List<Direction>>> =
    (0 until size).filter { index ->
        gradeByIndex(index) <= min(gradeByIndex(index - 1), gradeByIndex(index + 1))
    }.map { index -> when {
        gradeByIndex(index) == gradeByIndex(index + 1) -> index to listOf(Direction.LEFT)
        gradeByIndex(index) == gradeByIndex(index - 1) -> index to listOf(Direction.RIGHT)
        else -> index to listOf(Direction.LEFT, Direction.RIGHT)
    } }

private fun buildStopIndicesSet(gradeByIndex: (Int) -> Int, size: Int): Set<Int> =
    (0 until size).filter { index ->
        gradeByIndex(index) >= max(gradeByIndex(index - 1), gradeByIndex(index + 1))
    }.toSet()

enum class Direction {
    LEFT,
    RIGHT
}

fun Direction.next(index: Int): Int = when (this) {
    Direction.LEFT -> index - 1
    Direction.RIGHT -> index + 1
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }

    val result = candies(arr)

    println(result)
}
