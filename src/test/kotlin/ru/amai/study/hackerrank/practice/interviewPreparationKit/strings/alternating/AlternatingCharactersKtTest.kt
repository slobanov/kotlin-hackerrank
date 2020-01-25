package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.alternating

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class AlternatingCharactersKtTest {

    @ParameterizedTest
    @CsvSource(value = [
        "AAAA,3",
        "BBBBB,4",
        "ABABABAB,0",
        "BABABA,0",
        "AAABBB,4"
    ])
    fun alternatingCharacters(string: String, numberOfDeletions: Int) {
        assertThat(alternatingCharacters(string))
            .`as`("minimum number of deletions to make the alternating string from %s", string)
            .isEqualTo(numberOfDeletions)
    }

    @Test
    fun alternatingCharactersModuleTest() {
        moduleTest("""
            5
            AAAA
            BBBBB
            ABABABAB
            BABABA
            AAABBB
        """.trimIndent(), ::main) {
            verify {
                println(3)
                println(4)
                println(0)
                println(0)
                println(4)
            }
        }
    }
}
