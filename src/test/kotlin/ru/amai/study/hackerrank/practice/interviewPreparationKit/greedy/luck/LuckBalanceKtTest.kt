package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.luck

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.luck.Importance.IMPORTANT
import ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.luck.Importance.UNIMPORTANT
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class LuckBalanceKtTest {

    @ParameterizedTest
    @MethodSource("contestsProvider")
    fun luckBalanceTest(k: Int, contests: List<Contest>, resultLuck: Int) {
        assertThat(luckBalance(k, contests))
            .`as`("maximum amount of luck Lena can have after all '%s' with max of '%s' loses",
                contests,
                k
            ).isEqualTo(resultLuck)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun contestsProvider() = listOf(
            of(3, listOf(
                Contest(5, IMPORTANT),
                Contest(2, IMPORTANT),
                Contest(1, IMPORTANT),
                Contest(8, IMPORTANT),
                Contest(10, UNIMPORTANT),
                Contest(5, UNIMPORTANT)
            ), 29),
            of(3, listOf(
                Contest(5, IMPORTANT),
                Contest(1, IMPORTANT),
                Contest(4, UNIMPORTANT)
            ), 10)
        )
    }

    @Test
    fun luckBalanceModuleTest() {
        moduleTest("""
            6 3
            5 1
            2 1
            1 1
            8 1
            10 0
            5 0
        """.trimIndent(), ::main) {
            verify { println(29) }
        }
    }
}
