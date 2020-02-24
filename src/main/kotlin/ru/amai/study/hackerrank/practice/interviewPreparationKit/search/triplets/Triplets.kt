package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.triplets

import java.util.*

fun triplets(a: IntArray, b: IntArray, c: IntArray): Long {

    val (sortedA, aSize) = sortUniqueToSize(a)
    val (sortedB, bSize) = sortUniqueToSize(b)
    val (sortedC, cSize) = sortUniqueToSize(c)

    val totalSize = aSize + bSize + cSize

    var ai = 0
    var bi = 0
    var ci = 0

    var tripletsCnt = 0L

    while ((ai + bi + ci) < totalSize) {

        if (bi == bSize) break

        val p = sortedA.getOrMaxValue(ai)
        val q = sortedB.getOrMaxValue(bi)
        val r = sortedC.getOrMaxValue(ci)

        when {
            (p <= q) && (p <= r) -> ai++
            (r <= q) && (r <= p) -> ci++
            else -> {
                bi++
                tripletsCnt += ai.toLong() * ci.toLong()
            }
        }
    }

    return tripletsCnt
}

private fun IntArray.getOrMaxValue(index: Int) =
    if (index < size) get(index) else Int.MAX_VALUE

private fun sortUniqueToSize(array: IntArray): Pair<IntArray, Int> {
    val sortedUnique = array.sorted().distinct().toIntArray()
    return sortedUnique to sortedUnique.size
}

fun main() {
    val scan = Scanner(System.`in`)

    scan.nextLine().split(" ")

    fun readIntArray(): IntArray =
        scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val a = readIntArray()
    val b = readIntArray()
    val c = readIntArray()

    val ans = triplets(a, b, c)
    println(ans)
}
