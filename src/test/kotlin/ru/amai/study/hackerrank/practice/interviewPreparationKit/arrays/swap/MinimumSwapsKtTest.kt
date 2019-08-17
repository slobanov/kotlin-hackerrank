package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.swap

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class MinimumSwapsKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun minimumSwapsTest(swapCnt: Int, array: IntArray) {
        assertThat(minimumSwaps(array))
            .`as`(" minimum number of swaps to sort %s", toString(array))
            .isEqualTo(swapCnt)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayProvider() = listOf(
            of(3, intArrayOf(4, 3, 1, 2)),
            of(3, intArrayOf(2, 3, 4, 1, 5)),
            of(3, intArrayOf(1, 3, 5, 2, 4, 6, 7))
        )
    }

    @Test
    fun minimumSwapsModuleTest() {
        moduleTest("""
            7
            1 3 5 2 4 6 7
        """.trimIndent(),
            ::main) {
            verify { println(3) }
        }
    }
}
