package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.valley

import io.mockk.every
import io.mockk.mockkConstructor
import io.mockk.spyk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CountingValleysKtTest {

    @ParameterizedTest
    @MethodSource("pathProvider")
    fun countingValleysTest(valleyCnt: Int, pathString: String) {
        Assertions.assertThat(countingValleys(pathString))
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
        val scanner = Scanner("8${System.lineSeparator()}UDDDUDUU")
        mockkConstructor(Scanner::class)
        every {
            anyConstructed<Scanner>().nextLine()
        } answers { scanner.nextLine() }

        val outSpy = spyk(System.out)
        System.setOut(outSpy)

        main()

        verify { outSpy.println(1) }
    }
}
