package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.anagrams

import java.util.*

fun sherlockAndAnagrams(s: String): Int =
    (1..s.length).sumBy{ countNSizedAnagrams(s, it) }

private fun countNSizedAnagrams(s: String, n: Int): Int =
    s.windowed(n)
        .map { it.toList().sorted() }
        .groupingBy { it }
        .eachCount()
        .values
        .filter { it > 1 }
        .sumBy { it*(it - 1) / 2 }

fun main() {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = sherlockAndAnagrams(s)
        println(result)
    }
}
