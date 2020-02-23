package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.pairs

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class PairsKtTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun pairsTest(k: Int, arr: Array<Int>, pairsCnt: Int) {
        assertThat(pairs(k, arr))
            .`as`(
                "number of pairs of integers whose difference is '%s' from '%s'",
                k,
                arr.contentToString()
            )
            .isEqualTo(pairsCnt)
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun arrayProvider() = listOf(
            of(2, arrayOf(1, 5, 3, 4, 2), 3),
            of(2, arrayOf(1, 3, 5, 8, 6, 4, 2), 5)
        )
    }

    @Test
    fun pairsModuleTest() {
        moduleTest("""
            5 2  
            1 5 3 4 2  
        """.trimIndent(), ::main) {
            verify { println(3) }
        }
    }
}
