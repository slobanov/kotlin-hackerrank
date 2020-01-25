package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.alternating

import java.lang.StringBuilder
import java.util.*

fun alternatingCharacters(string: String): Int {
    val collapsedString = string.fold(StringBuilder()) { acc, c ->
        if (c == acc.lastOrNull()) acc
        else acc.append(c)
    }

    return string.length - collapsedString.length
}

fun main() {
    val scan = Scanner(System.`in`)

    val namQueries = scan.nextLine().trim().toInt()

    repeat(namQueries) {
        val s = scan.nextLine()
        val result = alternatingCharacters(s)
        println(result)
    }
}
