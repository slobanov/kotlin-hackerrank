package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.triplets

import java.util.*

fun triplets(a: IntArray, b: IntArray, c: IntArray): Long {

    val (aSorted, aSize) = sortUniqueToSize(a)
    val (bSorted, bSize) = sortUniqueToSize(b)
    val (cSorted, cSize) = sortUniqueToSize(c)

    val totalSize = aSize + bSize + cSize

    var aIndex = 0
    var bIndex = 0
    var cIndex = 0

    var tripletsCnt = 0L

    while ((aIndex + bIndex + cIndex) < totalSize) {

        if (bIndex == bSize) break

        val p = aSorted.getOrMaxValue(aIndex)
        val q = bSorted.getOrMaxValue(bIndex)
        val r = cSorted.getOrMaxValue(cIndex)

        when {
            (p <= q) && (p <= r) -> aIndex++
            (r <= q) && (r <= p) -> cIndex++
            else -> {
                bIndex++
                tripletsCnt += aIndex.toLong() * cIndex.toLong()
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
