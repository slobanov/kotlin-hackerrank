package ru.amai.study.hackerrank.practice.interviewPreparationKit.sorting.toys

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class MaximumToysKtTest {

    @ParameterizedTest
    @MethodSource("pricesProvider")
    fun maximumToysTest(prices: Array<Int>, sum: Int, result: Int) {
        assertThat(maximumToys(prices, sum))
            .`as`("the maximum number of toys from %s Mark can buy for his son using %s dollars",
                toString(prices), sum
            ).isEqualTo(result)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun pricesProvider() = listOf(
            of(arrayOf(1, 2, 3, 4), 7, 3),
            of(arrayOf(3, 7, 2, 9, 4), 15, 3)
        )
    }

    @Test
    fun maximumToysModuleTest() {
        moduleTest("""
            7 50
            1 12 5 111 200 1000 10
        """.trimIndent(),
            ::main) {
            verify { println(4) }
        }
    }

}
