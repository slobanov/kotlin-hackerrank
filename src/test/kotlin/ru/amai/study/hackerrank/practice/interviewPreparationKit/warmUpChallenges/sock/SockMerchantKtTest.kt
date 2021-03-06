package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.sock

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.lang.System.lineSeparator
import java.util.*

internal class SockMerchantKtTest {

    @ParameterizedTest
    @MethodSource("socksProvider")
    fun sockMerchantTest(numberOfPairs: Int, socksColors: Array<Int>) {
        assertThat(sockMerchant(socksColors))
            .`as`("number of matching pairs of socks for %s", socksColors.contentToString())
            .isEqualTo(numberOfPairs)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun socksProvider() = listOf(
            of(3, arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)),
            of(0, emptyArray<Int>()),
            of(0, arrayOf(1)),
            of(0, arrayOf(11, 12)),
            of(1, arrayOf(1, 1)),
            of(4, arrayOf(1, 1, 3, 1, 2, 1, 3, 3, 3, 3))
        )
    }

    @Test
    fun sockMerchantModuleTest() {
        moduleTest("9${lineSeparator()}10 20 20 10 10 30 50 10 20", ::main) {
            verify { println(3) }
        }
    }
}
