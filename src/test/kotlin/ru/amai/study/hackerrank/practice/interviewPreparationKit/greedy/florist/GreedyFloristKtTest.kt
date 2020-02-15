package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.florist

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class GreedyFloristKtTest {

    @ParameterizedTest
    @MethodSource("friendsAndListProvider")
    fun getMinimumCostTest(friendsCnt: Int, prices: List<Int>, minTotalPrice: Int) {
        assertThat(getMinimumCost(friendsCnt, prices))
            .`as`("minimum cost to buy all flowers with prices %s having %s friends",
                prices,
                friendsCnt
            ).isEqualTo(minTotalPrice)
    }
    companion object {
        @Suppress("unused")
        @JvmStatic
        fun friendsAndListProvider() = listOf(
            of(3, listOf(2, 5, 6), 13),
            of(2, listOf(2, 5, 6), 15),
            of(3, listOf(3, 5, 9, 7, 1), 29)
        )
    }

    @Test
    fun getMinimumCostModuleTest() {
        moduleTest("""
            5 3
            1 3 5 7 9
        """.trimIndent(), ::main) {
            verify { println(29) }
        }
    }
}
