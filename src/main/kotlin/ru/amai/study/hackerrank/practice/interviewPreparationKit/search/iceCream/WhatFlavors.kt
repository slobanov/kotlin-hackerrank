package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.iceCream

import java.lang.IllegalArgumentException
import java.util.*

fun whatFlavors(cost: IntArray, money: Int): String {
    val costToIndexMap = mutableMapOf<Int, Int>()

    cost.forEachIndexed { i, iCost ->
        val leftToSpend = money - iCost
        if (leftToSpend in costToIndexMap) {
            val j = costToIndexMap.getValue(leftToSpend)
            return listOf(i, j)
                .map { it + 1 }
                .sorted()
                .joinToString(separator = " ")
        }
        costToIndexMap += iCost to i
    }

    throw IllegalArgumentException(
        "There is no solution for money = $money and cost = $cost"
    )
}

fun main() {
    val scan = Scanner(System.`in`)

    val numTrips = scan.nextLine().trim().toInt()

    val result = (1..numTrips).joinToString(separator = "\n") {
        val money = scan.nextLine().trim().toInt()
        scan.nextLine()
        val costArray = scan.nextLine().trim().split(" ").map { it.trim().toInt() }.toIntArray()

        whatFlavors(costArray, money)
    }

    println(result)
}
