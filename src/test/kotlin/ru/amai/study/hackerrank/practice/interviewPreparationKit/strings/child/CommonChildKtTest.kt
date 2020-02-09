package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.child

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class CommonChildKtTest {

    @ParameterizedTest
    @CsvSource(value = [
        "HARRY,SALLY,2",
        "AA,BB,0",
        "SHINCHAN,NOHARAAA,3"
    ])
    fun commonChildTest(string1: String, string2: String, lcsLen: Int) {
        assertThat(commonChild(string1, string2))
            .`as`(
                "Length of the longest string, such that string is a child of both '%s' and '%s'",
                string1,
                string2
            ).isEqualTo(lcsLen)
    }

    @Test
    fun commonChildModuleTest() {
        moduleTest("""
            SHINCHAN
            NOHARAAA
        """.trimIndent(), ::main) {
            verify { println(3) }
        }
    }
}
