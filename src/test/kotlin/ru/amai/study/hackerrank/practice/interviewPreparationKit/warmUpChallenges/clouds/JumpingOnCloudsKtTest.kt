package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.clouds

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class JumpingOnCloudsKtTest {

    @ParameterizedTest
    @MethodSource("cloudProvider")
    fun jumpingOnCloudsTest(length: Int, clouds: Array<Int>) {
        assertThat(jumpingOnClouds(clouds))
            .`as`("minimum number of jumps needed for %s", toString(clouds))
            .isEqualTo(length)
    }

    @ParameterizedTest
    @MethodSource("badCloudProvider")
    fun jumpingOnCloudsRequireTest(expectedMsg: String, clouds: Array<Int>) {
        assertThat(catchThrowable { jumpingOnClouds(clouds) })
            .`as`("requirement error for ${toString(clouds)}")
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasNoCause()
            .hasMessage(expectedMsg)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun cloudProvider() = listOf(
            of(3, arrayOf(0, 0, 0, 0, 1, 0)),
            of(4, arrayOf(0, 0, 1, 0, 0, 1, 0)),
            of(6, arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0)),
            of(4, arrayOf(0, 1, 0, 1, 0, 0, 1, 0))
        )

        @Suppress("unused")
        @JvmStatic
        fun badCloudProvider() = listOf(
            of("clouds must be numbered 0 or 1; got [0, 1, 2]", arrayOf(0, 1, 2)),
            of("number of clouds should be <= 100 and >= 2; got 1", arrayOf(0)),
            of("first cloud should be 0; got 1", arrayOf(1, 0)),
            of("last cloud should be 0; got 1", arrayOf(0, 1)),
            of("there should not be two consecutive 1's in clouds; got [0, 1, 1, 0]", arrayOf(0, 1, 1, 0))
        )
    }

    @Test
    fun jumpingOnCloudsModuleTest() {
        moduleTest("6${System.lineSeparator()}0 0 0 0 1 0", ::main) {
            verify { println(3) }
        }
    }
}
