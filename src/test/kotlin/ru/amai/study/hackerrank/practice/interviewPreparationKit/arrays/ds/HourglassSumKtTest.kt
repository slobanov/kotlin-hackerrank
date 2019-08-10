package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.ds

import io.mockk.verify
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.deepToString

internal class HourglassSumKtTest {

    @ParameterizedTest
    @MethodSource("arrProvider")
    fun hourglassSumTest(arr: Array<Array<Int>>, expectedSum: Int) {
        assertThat(hourglassSum(arr))
            .`as`("largest hourglass sum found in %s", deepToString(arr))
            .isEqualTo(expectedSum)
    }

    @ParameterizedTest
    @MethodSource("badArrProvider")
    fun hourglassSumRequirementsTest(arr: Array<Array<Int>>) {
        assertThat(Assertions.catchThrowable { hourglassSum(arr) })
            .`as`("requirement error for ${deepToString(arr)}")
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasNoCause()
            .hasMessage("arr should be 2D 6 x 6; got %s", deepToString(arr))
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrProvider() = listOf(
            of(arrayOf(
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 1, 0, 0, 0, 0),
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 0, 2, 4, 4, 0),
                arrayOf(0, 0, 0, 2, 0, 0),
                arrayOf(0, 0, 1, 2, 4, 0)
            ), 19),
            of(arrayOf(
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 1, 0, 0, 0, 0),
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 9, 2, -4, -4, 0),
                arrayOf(0, 0, 0, -2, 0, 0),
                arrayOf(0, 0, -1, -2, -4, 0)
            ), 13)
        )

        @Suppress("unused")
        @JvmStatic
        fun badArrProvider() = listOf(
            of(arrayOf(
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 1, 0, 0, 0, 0),
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 0, 2, 4, 4, 0)
            )),
            of(arrayOf(
                arrayOf(1, 1, 1, 0, 0 ),
                arrayOf(0, 1, 0),
                arrayOf(1, 1, 0)
            )),
            of(arrayOf(
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 1, 0, 0, 0, 0),
                arrayOf(1, 1, 1, 0, 0, 0),
                arrayOf(0, 9, 2, -4),
                arrayOf(0, 0, 0, -2, 0, 0),
                arrayOf(0, 0, -1, -2, -4, 0)
            ))
        )
    }

    @Test
    fun hourglassSumModuleTest() {
        moduleTest("""
               1 1 1 0 0 0
               0 1 0 0 0 0
               1 1 1 0 0 0
               0 0 2 4 4 0
               0 0 0 2 0 0
               0 0 1 2 4 0
               """.trimIndent(),
            ::main) { verify { println(19) }
        }
    }
}
