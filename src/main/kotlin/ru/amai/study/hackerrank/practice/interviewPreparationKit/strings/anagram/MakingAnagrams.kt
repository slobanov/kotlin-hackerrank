package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.anagram

import java.util.*
import kotlin.math.absoluteValue

fun makeAnagram(firstString: String, secondString: String): Int {
    val charSet = (firstString + secondString).toSet()

    val (firstCharCount, secondCharCount) =
        listOf(firstString, secondString).map { it.charCount() }

    return charSet.sumBy { char ->
        (firstCharCount.getOrZero(char) - secondCharCount.getOrZero(char)).absoluteValue
    }
}

private fun String.charCount(): Map<Char, Int> = groupingBy { it }.eachCount()

private fun Map<Char, Int>.getOrZero(char: Char) = getOrDefault(char, 0)

fun main() {
    val scan = Scanner(System.`in`)
    val firstString = scan.nextLine()
    val secondString = scan.nextLine()

    val cntCharsToDelete = makeAnagram(firstString, secondString)
    println(cntCharsToDelete)
}
