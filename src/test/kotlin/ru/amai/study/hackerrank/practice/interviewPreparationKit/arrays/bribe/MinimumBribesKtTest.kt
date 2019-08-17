package ru.amai.study.hackerrank.practice.interviewPreparationKit.arrays.bribe

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class MinimumBribesKtTest {

    @ParameterizedTest
    @MethodSource("reachableQueueProvider")
    fun minimumBribesTest(result: String, queue: IntArray) {
        assertThat(minimumBribes(queue))
            .`as`("the minimum number of bribes needed to get %s", toString(queue))
            .isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("unreachableQueueProvider")
    fun minimumBribesChaoticTest(queue: IntArray) {
        assertThat(minimumBribes(queue)).isEqualTo("Too chaotic")
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun reachableQueueProvider() = listOf(
            of("3", intArrayOf(2, 1, 5, 3, 4)),
            of("7", intArrayOf(1, 2, 5, 3, 7, 8, 6, 4))
        )

        @Suppress("unused")
        @JvmStatic
        fun unreachableQueueProvider() = listOf(
            of(intArrayOf(2, 5, 1, 3, 4)),
            of(intArrayOf(5, 1, 2, 3, 7, 8, 6, 4))
        )
    }

    @Test
    fun minimumBribesModuleTest() {
        moduleTest("""
                2
                5
                2 1 5 3 4
                5
                2 5 1 3 4
        """.trimIndent(),
            ::main) {
            verify {
                print("3")
                print("Too chaotic")
            }
        }
    }
}
