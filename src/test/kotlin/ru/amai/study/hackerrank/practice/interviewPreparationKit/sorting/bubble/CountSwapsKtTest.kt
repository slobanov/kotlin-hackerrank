package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.bubble

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class CountSwapsKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun countSwapsTest(arr: Array<Int>, swapCnt: Int) {
        assertThat(countSwaps(arr))
            .`as`("number of swap to sort %s using bubble sort", toString(arr))
            .isEqualTo(swapCnt)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayProvider() = listOf(
            of(arrayOf(3, 2, 1), 3),
            of(arrayOf(4, 2, 3, 1), 5)
        )
    }

    @Test
    fun countSwapsModuleTest() {
        moduleTest("""
            3
            3 2 1
        """.trimIndent(),
            ::main) {
            verify {
                print("Array is sorted in 3 swaps.")
                print("First Element: 1")
                print("Last Element: 3")
            }
        }
    }
}
