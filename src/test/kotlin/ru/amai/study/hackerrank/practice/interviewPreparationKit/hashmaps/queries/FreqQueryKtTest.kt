package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.queries

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import java.util.Arrays.deepToString

internal class FreqQueryKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun freqQueryTest(queries: Array<IntArray>, result: List<Int>) {
        assertThat(freqQuery(queries))
            .`as`("outputs of queries of type 3 for %s", deepToString(queries))
            .isEqualTo(result)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayProvider() = listOf(
            of(arrayOf(
                intArrayOf(3, 4),
                intArrayOf(2, 1003),
                intArrayOf(1, 16),
                intArrayOf(3, 1)
            ), listOf(0, 1)),
            of(arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 2),
                intArrayOf(1, 4),
                intArrayOf(1, 5),
                intArrayOf(1, 5),
                intArrayOf(1, 4),
                intArrayOf(3, 2),
                intArrayOf(2, 4),
                intArrayOf(3, 2)
            ), listOf(0, 1, 1))
        )
    }

}
