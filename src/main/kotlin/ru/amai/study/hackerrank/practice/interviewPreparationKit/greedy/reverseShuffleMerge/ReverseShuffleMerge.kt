package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.reverseShuffleMerge

import java.util.*

fun reverseShuffleMerge(string: String): String {
    val resultLength = string.length / 2

    val charPositionsMap = string.withIndex()
        .groupBy { (_, char) -> char }
        .mapValues { (_, charAndPosList) -> charAndPosList.map { it.index } }

    val charsLeftToPick = charPositionsMap
        .mapValues { (_, posList) -> posList.size / 2 }
        .toSortedMap()
        .toMutableMap()

    val subStringCharCountMap = (0..string.length)
        .associateWith { i -> string.take(i).groupingBy { it }.eachCount() }

    var currPosition = string.length

    fun canPick(position: Int): Boolean {
        val remainingChars = subStringCharCountMap.getValue(position + 1)
        val beforeCurrPosition = position < currPosition

        return beforeCurrPosition && charsLeftToPick.all { (char, cnt) ->
            remainingChars[char] ?: 0 >= cnt
        }
    }

    return List(resultLength) {
        charsLeftToPick.keys.find { char ->
            val charPositions = charPositionsMap.getValue(char)
            val selectedPosition = charPositions.findLast(::canPick)

            selectedPosition?.let {
                currPosition = it
                charsLeftToPick[char] = charsLeftToPick.getValue(char) - 1
                if (charsLeftToPick[char] == 0) {
                    charsLeftToPick.remove(char)
                }
            }

            (selectedPosition != null)
        }
    }.joinToString("")
}

fun main() {
    val scan = Scanner(System.`in`)
    val s = scan.nextLine()

    println(reverseShuffleMerge(s))
}
