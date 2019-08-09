package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.clouds

import java.util.*
import java.util.Arrays.toString

private const val MAX_CLOUDS = 100
private const val MIN_CLOUDS = 2

fun jumpingOnClouds(clouds: Array<Int>): Int {
    checkRequirement(clouds)

    fun isThunder(cloud: Int) = cloud == 1

    val (totalPenalty, _) = clouds.withIndex()
        .fold(0 to PenaltyState.EVEN) { (penalty, penaltyState), (indx, cloud) ->
            if (isThunder(cloud) && penaltyState.isApplicable(indx)) {
                (penalty+1) to penaltyState.flip()
            } else penalty to penaltyState
        }

    return (clouds.size + totalPenalty) / 2
}

private fun checkRequirement(clouds: Array<Int>) {
    require(clouds.all { it in listOf(0, 1) }) {
        "clouds must be numbered 0 or 1; got ${toString(clouds)}"
    }
    require(clouds.size in MIN_CLOUDS..MAX_CLOUDS) {
        "number of clouds should be <= $MAX_CLOUDS and >= $MIN_CLOUDS; got ${clouds.size}"
    }
    require(clouds.first() == 0) { "first cloud should be 0; got ${clouds.first()}"}
    require(clouds.last() == 0) { "last cloud should be 0; got ${clouds.last()}"}
    require(
        clouds.toList()
            .zipWithNext()
            .map { (curr, next) -> curr+next }.all { it != 2 }
    ) { "there should not be two consecutive 1's in clouds; got ${toString(clouds)}" }
}

enum class PenaltyState {
    EVEN,
    ODD;

    fun flip() = when(this) {
        EVEN -> ODD
        ODD -> EVEN
    }

    fun isApplicable(indx: Int) = when(this) {
       EVEN -> indx % 2 == 0
       ODD -> indx % 2 == 1
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    scanner.nextLine().trim()
    val clouds = scanner.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(clouds)
    println(result)
}
