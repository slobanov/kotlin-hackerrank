package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.merge

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class CountInversionsKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun countInversionsTest(arr: IntArray, inversionCnt: Long) {
        assertThat(countInversions(arr))
            .`as`("number of inversions that must be swapped to sort the %s", toString(arr))
            .isEqualTo(inversionCnt)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayProvider() = listOf(
            Arguments.of(intArrayOf(2, 1, 5, 3, 4), 3L),
            Arguments.of(intArrayOf(1, 2, 5, 3, 7, 8, 6, 4), 7L)
        )
    }

    @Test
    fun countInversionsModuleTest() {
        moduleTest("""
            2
            5
            1 1 1 2 2
            5
            2 1 3 1 2
        """.trimIndent(),
            ::main) {
            verify {
                println(0L)
                println(4L)
            }
        }
    }

}
