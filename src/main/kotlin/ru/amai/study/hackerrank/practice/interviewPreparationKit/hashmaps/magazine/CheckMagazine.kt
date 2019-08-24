package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.magazine

import java.util.*

fun checkMagazine(magazine: Array<String>, note: Array<String>): String {
    fun Array<String>.valueCount() = groupingBy { it }.eachCount()

    val magazineMap = magazine.valueCount()
    val noteMap = note.valueCount()

    val canWriteNote = noteMap.all { (word, cnt) ->
        word in magazineMap && magazineMap.getValue(word) >= cnt
    }

    return if (canWriteNote) "Yes" else "No"
}

fun main() {
    val scan = Scanner(System.`in`)

    val mn = scan.nextLine().split(" ")
    mn[0].trim().toInt()
    mn[1].trim().toInt()

    val magazine = scan.nextLine().split(" ").toTypedArray()
    val note = scan.nextLine().split(" ").toTypedArray()

    println(checkMagazine(magazine, note))
}
