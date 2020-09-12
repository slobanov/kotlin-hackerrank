package ru.amai.study.hackerrank.practice.interviewPreparationKit.dynamic.abbreviation

import java.util.*

fun abbreviation(a: String, b: String): String {
    val aLength = a.length
    val bLength = b.length

    val resultMatrix = Array(aLength + 1) { Array(bLength + 1) { false } }

    resultMatrix[0][0] = true
    for (i in 1..aLength) {
        resultMatrix[i][0] = a[i - 1].isLowerCase() && resultMatrix[i - 1][0]
    }

    for (i in 1..aLength) {
        for (j in 1..bLength) {
            val ifSkip = (a[i - 1].isLowerCase()) && resultMatrix[i - 1][j]
            val ifKeep = (a[i - 1].toUpperCase() == b[j - 1]) && resultMatrix[i - 1][j - 1]

            resultMatrix[i][j] = ifSkip || ifKeep
        }
    }

    return if (resultMatrix[aLength][bLength]) "YES" else "NO"
}

fun main() {
    val scan = Scanner(System.`in`)
    val q = scan.nextLine().trim().toInt()

    repeat(q) {
        val a = scan.nextLine().trim()
        val b = scan.nextLine().trim()

        val result = abbreviation(a, b)
        println(result)
    }
}
