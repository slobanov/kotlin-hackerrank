package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.valley

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class CountingValleysKtTest {

    @ParameterizedTest
    @MethodSource("pathProvider")
    fun countingValleysTest(valleyCnt: Int, pathString: String) {
        assertThat(countingValleys(pathString))
            .`as`("number of valleys for $pathString")
            .isEqualTo(valleyCnt)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun pathProvider() = listOf(
            of(1, "UDDDUDUU"),
            of(2, "DDUUDDUDUUUD"),
            of(0, ""),
            of(0, "UUUUUU"),
            of(0, "UUUDDUUDU")
        )
    }

    @Test
    fun countingValleysInvalidInput() {
        val badPathString = "UUUDDADD"

        val exception = catchThrowable { countingValleys(badPathString) }
        assertThat(exception).isInstanceOf(IllegalArgumentException::class.java)
            .hasNoCause()
            .hasMessage("pathString must contain only 'U' or 'D', but got $badPathString")
    }

    @Test
    fun countingValleysModuleTest() {
        moduleTest("8${System.lineSeparator()}UDDDUDUU", ::main) {
            verify { println(1) }
        }
    }
}
