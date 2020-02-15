package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.minMax

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class MinMaxKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun maxMinTest(k: Int, arr: IntArray, minMaxVal: Int) {
        assertThat(maxMin(k, arr))
            .`as`("minimum possible value of unfairness for sub arrays of '%s' of size %s",
                arr.contentToString(),
                k
            ).isEqualTo(minMaxVal)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayProvider() = listOf(
            of(4, intArrayOf(1, 2, 3, 4, 10, 20, 30, 40, 100, 200), 3),
            of(3, intArrayOf(10, 100, 300, 200, 1000, 20, 30), 20)
        )
    }

    @Test
    fun maxMinModuleTest() {
        moduleTest("""
            10
            4
            1
            2
            3
            4
            10
            20
            30
            40
            100
            200
        """.trimIndent(), ::main) {
            verify { println(3) }
        }
    }
}
