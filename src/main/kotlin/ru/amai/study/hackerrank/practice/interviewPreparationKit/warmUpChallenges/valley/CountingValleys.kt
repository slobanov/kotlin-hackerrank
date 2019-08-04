package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.valley

import java.util.*

fun countingValleys(pathString: String): Int {

    require(pathString.none { note -> note !in listOf('U', 'D') }) {
        "pathString must contain only 'U' or 'D', but got $pathString"
    }

    fun toLevelChange(note: Char) =
        if (note == 'U') 1
        else -1

    fun updateValleyCount(valleyCnt: Int, currLevel: Int, levelChange: Int) =
        valleyCnt + if (currLevel == 0 && levelChange == -1) 1 else 0

    val (_, totalValleysCnt) = pathString
        .map(::toLevelChange)
        .fold(0 to 0) { (currLevel, valleyCnt), levelChange ->
            (currLevel + levelChange) to updateValleyCount(valleyCnt, currLevel, levelChange)
    }

    return totalValleysCnt
}

fun main() {
    val scan = Scanner(System.`in`)
    scan.nextLine()
    val pathString = scan.nextLine()

    val numberOfValleys = countingValleys(pathString)
    println(numberOfValleys)
}
