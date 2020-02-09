package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.special

import java.lang.Integer.max
import java.util.*

fun subStrCount(string: String): Long =
    cntSubstringsWithSameChars(string) + cntSubstringsWithSameCharsExceptMiddle(string)

private fun cntSubstringsWithSameCharsExceptMiddle(string: String): Long {

    fun withinBounds(index: Int, offset: Int): Boolean =
        ((index - offset) >= 0) && ((index + offset) < string.length)

    fun substringIsValid(currChar: Char, index: Int, offset: Int): Boolean =
        if (withinBounds(index, offset)) {
            val lChar = string[index - offset]
            val rChar = string[index + offset]

            (lChar == currChar) && (rChar == currChar)
        } else false

    var substringCnt = 0L
    var index = 1
    while (index < string.length - 1) {

        val currChar = string[index - 1]
        if (string[index] == currChar) {
            index++
            continue
        }

        val offset = generateSequence(1) { it + 1 }
            .takeWhile { offset -> substringIsValid(currChar, index, offset) }
            .count()

        substringCnt += offset
        index += max(offset, 1)
    }

    return substringCnt
}

private fun cntSubstringsWithSameChars(string: String): Long =
    string.drop(1).fold(CharCounterHolder(string.first())) { counter, char ->
        if (char == counter.char) counter.increment()
        else counter.switchChar(char)
    }.countValue()

private data class CharCounterHolder(
    val char: Char,
    val currentCount: Long = 1L,
    val partialResult: Long = 0
) {
    fun increment(): CharCounterHolder =
        copy(currentCount = currentCount + 1)

    fun switchChar(char: Char) =
        CharCounterHolder(char = char, partialResult = countValue())

    fun countValue() = partialResult + (currentCount * (currentCount + 1) / 2)
}

fun main() {
    val scan = Scanner(System.`in`)

    scan.nextLine()
    val s = scan.nextLine()

    val result = subStrCount(s)
    println(result)
}
