package ru.amai.study.hackerrank.practice.interviewPreparationKit.dynamic.maxSubsetSum

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class MaxSubsetSumKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun maxSubsetSumTest(array: Array<Int>, result: Int) {
        assertThat(maxSubsetSum(array))
            .`as`("maximum subset sum for '%s'", array.contentToString())
            .isEqualTo(result)
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun arrayProvider() = listOf(
            of(arrayOf(3, 5, -7, 8, 10), 15),
            of(arrayOf(2, 1, 5, 8, 4), 11),
            of(arrayOf(-2, 1, 3, -4, 5), 8)
        )
    }

    @Test
    fun maxSubsetSumModuleTest() {
        moduleTest("""
            5
            3 5 -7 8 10
        """.trimIndent(), ::main) {
            verify { println(15) }
        }
    }
}
