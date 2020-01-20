package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.fraud

import java.util.*

private const val MAX_EXPENDITURE = 201

fun activityNotifications(expenditure: IntArray, d: Int): Int {
    val counts = buildCounts(expenditure, d)

    return (d until expenditure.size).count { i ->
        val median = median(counts, d)

        counts[expenditure[i]] += 1
        counts[expenditure[i - d]] -= 1

        (expenditure[i] >= 2 * median)
    }
}

private fun buildCounts(array: IntArray, size: Int): IntArray {
    val counts = IntArray(MAX_EXPENDITURE)
    array.take(size).forEach {
        counts[it] += 1
    }
    return counts
}

private fun median(counts: IntArray, size: Int): Double {
    fun medianSupport(index: Int): Double {
        var currIndex = 0
        var value = 0.0
        for ((i, count) in counts.withIndex()) {
            if (index in (currIndex until (currIndex + count))) {
                value = i.toDouble()
                break
            }
            currIndex += count
        }
        return value
    }

    return when (size % 2) {
        1 -> medianSupport(size / 2)
        else -> (medianSupport(size / 2 - 1) + medianSupport(size / 2)) / 2
    }
}

fun main() {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")
    val d = nd[1].trim().toInt()
    val expenditure = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val result = activityNotifications(expenditure, d)
    println(result)
}
