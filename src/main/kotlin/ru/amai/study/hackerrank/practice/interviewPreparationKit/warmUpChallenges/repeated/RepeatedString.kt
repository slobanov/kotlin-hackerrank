package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.repeated


import java.util.*

fun repeatedString(str: String, charCnt: Long): Long =
    if (str.isNotEmpty()) {
        fun countA(s: String) = s.count { it == 'a' }

        val fullStrCount = if (str.isNotEmpty()) {
            charCnt / str.length
        } else 0
        val latestStrPart = (charCnt % str.length).toInt()

        fullStrCount*countA(str) + countA(str.take(latestStrPart))
    } else 0

fun main() {
    val scanner = Scanner(System.`in`)
    val str = scanner.nextLine()
    val charCnt = scanner.nextLine().trim().toLong()

    val result = repeatedString(str, charCnt)
    println(result)
}
