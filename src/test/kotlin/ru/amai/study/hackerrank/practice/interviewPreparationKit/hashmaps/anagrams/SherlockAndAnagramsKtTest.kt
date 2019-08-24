package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.anagrams

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class SherlockAndAnagramsKtTest {

    @ParameterizedTest
    @CsvSource(
        "abba,4",
        "abcd,0",
        "ifailuhkqq,3",
        "kkkk,10"
    )
    fun sherlockAndAnagramsTest(s: String, result: Int) {
        assertThat(sherlockAndAnagrams(s))
            .`as`("return the number of unordered anagrammatic pairs in '%s'", s)
            .isEqualTo(result)
    }

    @Test
    fun sherlockAndAnagramsModuleTest() {
        moduleTest("""
            2
            ifailuhkqq
            kkkk
        """.trimIndent(),
            ::main) {
            verify {
                println(3)
                println(10)
            }
        }
    }
}
