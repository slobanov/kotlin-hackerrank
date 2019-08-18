package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.manipulation

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.deepToString

internal class ArrayManipulationKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun arrayManipulationTest(n: Int, maxValue: Long, queries: Array<IntArray>) {
        assertThat(arrayManipulation(n, queries))
            .`as`("maximum value after %s", deepToString(queries))
            .isEqualTo(maxValue)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayProvider() = listOf(
            of(5, 200, arrayOf(
                intArrayOf(1, 2, 100),
                intArrayOf(2, 5, 100),
                intArrayOf(3, 4, 100)
            )),
            of(10, 10, arrayOf(
                intArrayOf(1, 5, 3),
                intArrayOf(4, 8, 7),
                intArrayOf(6, 9, 1)
            ))
        )
    }

    @Test
    fun arrayManipulationModuleTest() {
        moduleTest("""
            5 3
            1 2 100
            2 5 100
            3 4 100
        """.trimIndent(),
            ::main) {
            verify { println(200L) }
        }
    }
}
