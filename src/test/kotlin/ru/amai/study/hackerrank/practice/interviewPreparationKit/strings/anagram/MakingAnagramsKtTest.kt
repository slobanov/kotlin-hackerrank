package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.anagram

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class MakingAnagramsKtTest {

    @ParameterizedTest
    @CsvSource(value = [
        "'','',0",
        "'',abc,3",
        "cde,abc,4"
    ])
    fun makeAnagram(firstString: String, secondString: String, charsToDelete: Int) {
        assertThat(makeAnagram(firstString, secondString))
            .`as`("""minimum total characters that must be deleted
                | to make the strings %s and %s anagrams""".trimMargin(),
                firstString, secondString)
            .isEqualTo(charsToDelete)
    }

    @Test
    fun makingAnagramsModuleTest() {
        moduleTest("""
            cde
            abc
        """.trimIndent(), ::main) {
            verify { println(4) }
        }
    }
}
