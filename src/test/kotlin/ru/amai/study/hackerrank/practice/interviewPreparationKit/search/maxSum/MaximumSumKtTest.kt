package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.maxSum

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class MaximumSumKtTest {

    @ParameterizedTest
    @MethodSource("listProvider")
    fun maximumSumTest(list: List<Long>, divisor: Long, maxSum: Long) {
        assertThat(maximumSum(list, divisor))
            .`as`(
                "maximum value of sublist sum mod '%s' for '%s'",
                divisor,
                list
            )
            .isEqualTo(maxSum)
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun listProvider() = listOf(
            of(listOf(3L, 3L, 9L, 9L, 5L), 7L, 6L),
            of(listOf(1L, 5L, 9L), 5L, 4L),
            of(listOf(1L, 2L, 3L), 2L, 1L)
        )
    }

    @Test
    fun maximumSumModuleTest() {
        moduleTest("""
            1
            5 7
            3 3 9 9 5
        """.trimIndent(), ::main) {
            verify { println(6L) }
        }
    }
}
