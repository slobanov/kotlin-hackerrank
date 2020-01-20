package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.triplets

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.*

internal class CountTripletsKtTest {

    @ParameterizedTest
    @MethodSource("arrayAndRatioProvider")
    fun countTripletsTest(array: LongArray, ratio: Long, result: Long) {
        assertThat(countTriplets(array, ratio))
            .`as`(
                "count of triplets that form a geometric progression with ratio '%s' in '%s'",
                ratio,
                array.contentToString()
            ).isEqualTo(result)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arrayAndRatioProvider() = listOf(
            of(longArrayOf(1L, 3L, 9L, 9L, 27L, 81L), 3L, 6L),
            of(longArrayOf(1L, 5L, 5L, 25L, 125L), 5L, 4L),
            of(longArrayOf(1L, 2L, 2L, 4L), 2L, 2L),
            of(longArrayOf(1L, 2L, 4L, 2L, 4L), 2L, 3L),
            of(longArrayOf(1L, 1L, 1L, 1L, 1L, 1L, 1L), 1L, 35L)
        )
    }

    @Test
    fun countTripletsModuleTest() {
        moduleTest("""
                6 3
                1 3 9 9 27 81
        """.trimIndent(),
            ::main) { verify { println(6L) }
        }
    }
}
