package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.special

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class SubstrCountKtTest {

    @ParameterizedTest
    @CsvSource(value = [
        "asasd,7",
        "abcbaba,10",
        "aaaa,10"
    ])
    fun subStrCount(string: String, subStringCount: Long) {
        assertThat(subStrCount(string))
            .`as`("count of total special substrings for '%s'", string)
            .isEqualTo(subStringCount)
    }

    @Test
    fun subStrCountModuleTest() {
        moduleTest("""
            7
            abcbaba
        """.trimIndent(), ::main) {
            verify { println(10L) }
        }
    }
}
