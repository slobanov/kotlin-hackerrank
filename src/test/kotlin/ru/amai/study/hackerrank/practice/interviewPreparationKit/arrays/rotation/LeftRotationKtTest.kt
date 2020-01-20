package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.rotation

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class LeftRotationKtTest {

    @ParameterizedTest
    @MethodSource("arrProvider")
    fun rotLeftTest(arr: Array<Int>, d: Int, expectedArr: Array<Int>) {
        assertThat(rotLeft(arr, d))
            .`as`("state of the %s after performing %s left rotations", arr.contentToString(), d)
            .isEqualTo(expectedArr)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrProvider() = listOf(
            of(arrayOf(1, 2, 3, 4, 5), 4, arrayOf(5, 1, 2, 3, 4)),
            of(
                arrayOf(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51),
                10,
                arrayOf(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77)
            ),
            of(arrayOf(1, 2, 3), 4, arrayOf(2, 3, 1))
        )
    }

    @Test
    fun leftRotationKtModuleTest() {
        moduleTest("""
            5 4
            1 2 3 4 5
        """.trimIndent(), ::main) {
            verify { print("5 1 2 3 4") }
        }
    }
}
