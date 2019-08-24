package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.strings

import java.util.*

fun twoStrings(s1: String, s2: String): String {
    val s1Set = s1.toSet()
    return if (s2.any { it in s1Set }) "YES" else "NO"
}

fun main() {
    val scan = Scanner(System.`in`)
    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()
        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)
        println(result)
    }
}
