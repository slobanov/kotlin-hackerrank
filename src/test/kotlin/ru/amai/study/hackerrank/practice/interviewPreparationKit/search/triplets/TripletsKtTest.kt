package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.triplets

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class TripletsKtTest {

    @ParameterizedTest
    @MethodSource("arraysProvider")
    fun tripletsTest(a: IntArray, b: IntArray, c: IntArray, tripletsCnt: Long) {
        assertThat(triplets(a, b, c))
            .`as`(
                "number of distinct triplets for a = %s, b = %s and c = %s",
                a.contentToString(),
                b.contentToString(),
                c.contentToString()
            )
            .isEqualTo(tripletsCnt)
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun arraysProvider() = listOf(
            of(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(5, 7, 9),
                intArrayOf(7, 9, 11, 13),
                12L
            ),
            of(
                intArrayOf(1, 3, 5),
                intArrayOf(2, 3),
                intArrayOf(1, 2, 3),
                8L
            ),
            of(
                intArrayOf(1, 4, 5),
                intArrayOf(2, 3, 3),
                intArrayOf(1, 2, 3),
                5L
            )
        )
    }

    @Test
    fun tripletsModuleTest() {
        moduleTest("""
            4 3 4
            1 3 5 7
            5 7 9
            7 9 11 13
        """.trimIndent(), ::main) {
            verify { println(12L) }
        }
    }
}
