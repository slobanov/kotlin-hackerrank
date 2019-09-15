package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.fraud

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class ActivityNotificationsKtTest {

    @ParameterizedTest
    @MethodSource("expenditureProvider")
    fun activityNotificationsTest(expenditure: IntArray, d: Int, alerts: Int) {
        assertThat(activityNotifications(expenditure, d))
            .`as`(
                "total number of times the client receives a notification for %s with '%s' window",
                toString(expenditure),
                d
            )
            .isEqualTo(alerts)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun expenditureProvider() = listOf(
            of(intArrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5), 5, 2),
            of(intArrayOf(1, 2, 3, 4, 4), 4, 0),
            of(intArrayOf(10, 20, 30, 40, 50), 3, 1)
        )
    }

    @Test
    fun activityNotificationsModuleTest() {
        moduleTest("""
                9 5
                2 3 4 2 3 6 8 4 5
        """.trimIndent(), ::main) {
            verify { println(2) }
        }
    }

}
