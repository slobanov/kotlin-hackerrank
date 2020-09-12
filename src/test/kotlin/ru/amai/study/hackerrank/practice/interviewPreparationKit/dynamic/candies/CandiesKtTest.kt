package ru.amai.study.hackerrank.practice.interviewPreparationKit.dynamic.candies

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class CandiesKtTest {

    @ParameterizedTest
    @MethodSource("arrProvider")
    fun candiesTest(arr: Array<Int>, totalCandies: Long) {
        assertThat(candies(arr))
            .`as`("minimum number of candies Alice must buy for ${arr.contentToString()}")
            .isEqualTo(totalCandies)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrProvider() = listOf(
            of(arrayOf(1, 2, 2), 4L),
            of(arrayOf(2, 4, 2, 6, 1, 7, 8, 9, 2, 1), 19L),
            of(arrayOf(1, 2, 2, 3, 3, 2, 2, 1, 1), 13L)
        )
    }

    @Test
    fun candiesModuleTest() {
        moduleTest("""
            3
            1
            2
            2
        """.trimIndent(), ::main) {
            verify { println(4L) }
        }
    }
}
