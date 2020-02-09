package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.difference

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class MinimumAbsoluteDifferenceKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun minimumAbsoluteDifferenceTest(arr: Array<Int>, minAbsDifference: Int) {
        assertThat(minimumAbsoluteDifference(arr))
            .`as`("Minimum absolute difference between any two elements in the %s", arr.contentToString())
            .isEqualTo(minAbsDifference)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayProvider() = listOf(
            of(arrayOf(1, -3, 71, 68, 17), 3),
            of(arrayOf(3, -7, 0), 3)
        )
    }

    @Test
    fun minimumAbsoluteDifferenceModuleTest() {
        moduleTest("""
            5
            1 -3 71 68 17
        """.trimIndent(), ::main) {
            verify { println(3) }
        }
    }
}
