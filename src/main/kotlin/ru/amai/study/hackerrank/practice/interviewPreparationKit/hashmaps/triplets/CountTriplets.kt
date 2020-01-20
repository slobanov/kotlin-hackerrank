package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.triplets

import java.util.*

fun countTriplets(array: LongArray, ratio: Long): Long {
    fun modR(iv: IndexedValue<Long>) = iv.value % ratio == 0L
    fun divR(iv: IndexedValue<Long>) = IndexedValue(iv.index, iv.value / ratio)

    fun List<IndexedValue<Long>>.indexes() = map { (index, _) -> index }

    fun candidates(power: Int) =
        (0 until power).fold(array.withIndex()) { curArr, _ ->
            curArr.filter(::modR).map(::divR)
        }.groupBy { (_, value) -> value }
         .mapValues { (_, indexedValues) -> indexedValues.indexes() }

    val (iCandidates, jCandidates, kCandidates) =
        listOf(0, 1, 2).map(::candidates)

    val commonBases = kCandidates.keys.filter { v ->
        (v in iCandidates) && (v in jCandidates)
    }

    return commonBases.map { v ->
        val kvCandidates = kCandidates.getValue(v)
        val jvCandidates = jCandidates.getValue(v)
        val ivCandidates = iCandidates.getValue(v)

        countTriplesForSingleBaseValue(ivCandidates, jvCandidates, kvCandidates)
    }.sum()
}

private fun countTriplesForSingleBaseValue(
    ivCandidates: List<Int>,
    jvCandidates: List<Int>,
    kvCandidates: List<Int>
): Long {
    var i = 0
    var j = 0
    var k = 0
    var iCnt = 0L
    var jCnt = 0L
    var kCnt = 0L

    while ((k < kvCandidates.size) && (i < ivCandidates.size) && (j < jvCandidates.size)) {
        val ivc = ivCandidates[i]
        val jvc = jvCandidates[j]
        val kvc = kvCandidates[k]

        when {
            kvc <= jvc -> {
                kCnt += jCnt
                k++
            }
            jvc <= ivc -> {
                jCnt += iCnt
                j++
            }
            else -> {
                i++
                iCnt += 1L
            }
        }
    }

    while ((k < kvCandidates.size) && (j < jvCandidates.size)) {
        val jvc = jvCandidates[j]
        val kvc = kvCandidates[k]

        when {
            kvc <= jvc -> {
                kCnt += jCnt
                k++
            }
            else -> {
                jCnt += iCnt
                j++
            }
        }
    }

    if ((k < kvCandidates.size) && (kvCandidates[k] > jvCandidates.last())) {
        kCnt += jCnt * (kvCandidates.size - k)
    }

    return kCnt
}

fun main() {
    val scanner = Scanner(System.`in`)
    val nr = scanner.nextLine().trim().split(" ")

    val r = nr[1].toLong()
    val array = scanner.nextLine().trim().split(" ").map { it.toLong() }.toLongArray()

    val result = countTriplets(array, r)
    println(result)
}
