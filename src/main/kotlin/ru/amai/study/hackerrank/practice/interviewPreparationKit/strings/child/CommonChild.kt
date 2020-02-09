package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.child

import java.lang.Integer.max
import java.util.*

fun commonChild(string1: String, string2: String): Int {
    val string1Length = string1.length
    val string2Length = string2.length

    val resultMatrix = Array(string1Length + 1) {
        IntArray(string2Length + 1) { 0 }
    }

    for (i in 1..string1Length) {
        for (j in 1..string2Length) {
            if (string1[i - 1] == string2[j - 1]) {
                resultMatrix[i][j] = resultMatrix[i - 1][j - 1] + 1
            } else {
                resultMatrix[i][j] = max(resultMatrix[i - 1][j], resultMatrix[i][j - 1])
            }
        }
    }

    return resultMatrix[string1Length][string2Length]
}

fun main() {
    val scan = Scanner(System.`in`)

    val string1 = scan.nextLine()
    val string2 = scan.nextLine()

    println(commonChild(string1, string2))
}
