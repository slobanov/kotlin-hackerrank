package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.minTime

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class MinTimeKtTest {

    @ParameterizedTest
    @MethodSource("machinesProvider")
    fun minTimeTest(machines: List<Int>, goal: Int, time: Long) {
        assertThat(minTime(machines, goal))
            .`as`(
                "time required to produce '%s' items considering all machines '%s' work simultaneously",
                goal,
                machines
            )
            .isEqualTo(time)
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun machinesProvider() = listOf(
            of(listOf(1, 3, 4), 10, 7),
            of(listOf(4, 5, 6), 12, 20)
        )
    }

    @Test
    fun minTimeModuleTest() {
        moduleTest("""
            3 12
            4 5 6
        """.trimIndent(), ::main) {
            verify { println(20L) }
        }
    }
}
