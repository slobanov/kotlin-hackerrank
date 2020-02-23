package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.swap

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class SwapNodesKtTest {

    @ParameterizedTest
    @MethodSource("swapNodesDataProvider")
    fun swapNodesTest(indexes: Array<Array<Int>>, queries: Array<Int>, result: List<List<Int>>) {
        assertThat(swapNodes(indexes, queries))
            .`as`(
                "In-order traversal of '%s' after '%s' queries",
                indexes.contentDeepToString(),
                queries.contentToString()
            )
            .isEqualTo(result)
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun swapNodesDataProvider() = listOf(
            of(
                arrayOf(
                    arrayOf(2, 3),
                    arrayOf(-1, 4),
                    arrayOf(-1, 5),
                    arrayOf(-1, -1),
                    arrayOf(-1, -1)
                ),
                arrayOf(2),
                listOf(
                    listOf(4, 2, 1, 5, 3)
                )
            ),
            of(
                arrayOf(
                    arrayOf(2, 3),
                    arrayOf(-1, -1),
                    arrayOf(-1, -1)
                ),
                arrayOf(1, 1),
                listOf(
                    listOf(3, 1, 2),
                    listOf(2, 1, 3)
                )
            )
        )
    }

    @Test
    fun swapNodesModuleTest() {
        moduleTest("""
            11
            2 3
            4 -1
            5 -1
            6 -1
            7 8
            -1 9
            -1 -1
            10 11
            -1 -1
            -1 -1
            -1 -1
            2
            2
            4
        """.trimIndent(), ::main) {
            verify {
                print("2 9 6 4 1 3 7 5 11 8 10\n2 6 9 4 1 3 7 5 10 8 11")
            }
        }
    }
}
