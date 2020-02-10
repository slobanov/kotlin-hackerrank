package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.luck

import java.lang.IllegalArgumentException
import java.util.*

fun luckBalance(k: Int, contests: List<Contest>): Int {
    val (importantContests, unimportanceContests) =
        contests.partition { it.importance == Importance.IMPORTANT }

    val sortedImportantContests =
        importantContests.sortedBy { it.luck }

    val lostContestLuck =
        (unimportanceContests + sortedImportantContests.takeLast(k)).totalLuck

    val importantContestsCnt = importantContests.size

    return if (importantContestsCnt > k) {
        val winContestsLuck =
            sortedImportantContests.take(importantContestsCnt - k).totalLuck

        lostContestLuck - winContestsLuck
    } else lostContestLuck
}

private val List<Contest>.totalLuck: Int
        get() = sumBy { it.luck }

data class Contest(val luck: Int, val importance: Importance)

enum class Importance {
    IMPORTANT,
    UNIMPORTANT
}

private fun from(importanceValue: Int): Importance = when (importanceValue) {
    0 -> Importance.UNIMPORTANT
    1 -> Importance.IMPORTANT
    else -> throw IllegalArgumentException(
        "got illegal importanceValue = $importanceValue; 0 or 1 expected"
    )
}

fun main() {
    val scan = Scanner(System.`in`)

    val (n, k) = scan.nextLine().split(" ").map { it.toInt() }

    val contests = (1..n).map {
        val (luck, importanceValue) = scan.nextLine().split(" ").map { it.trim().toInt() }
        Contest(luck, from(importanceValue))
    }

    val result = luckBalance(k, contests)
    println(result)
}
