package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.minTime

import java.util.*
import kotlin.math.ceil
import kotlin.math.floor

fun minTime(machines: List<Int>, goal: Int): Long {
    fun producedByMachinesIn(time: Long): Long =
        machines.fold(0L) { total, machine -> total + time / machine }

    val approxIndividualGoal = goal.toDouble() / machines.size
    val lowerBound: Long = floor(approxIndividualGoal).toLong() * machines.min()!!
    val upperBound: Long = ceil(approxIndividualGoal).toLong() * machines.max()!!

    fun search(left: Long, right: Long): Long {
        check(right > left) { "right ($right) should be > left ($left)" }

        val mTime = (left + right) / 2
        val mQuantity = producedByMachinesIn(mTime)
        return when {
            mQuantity < goal -> search(mTime + 1, right)
            (mQuantity >= goal) && (producedByMachinesIn(mTime - 1) < goal) -> mTime
            else -> search(left, mTime)
        }
    }

    return search(lowerBound, upperBound)
}

fun main() {
    val scan = Scanner(System.`in`)

    fun readLongList() = scan.nextLine().split(" ").map { it.trim().toInt() }

    val (_, goal) = readLongList()
    val machines = readLongList()

    val ans = minTime(machines, goal)
    println(ans)
}
