package ru.amai.study.hackerrank.practice.interviewPreparationKit.strings.sherlock

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class IsValidKtTest {

    @ParameterizedTest
    @CsvSource(value = [
        "aabbcd,NO",
        "aabbccddeefghi,NO",
        "abcdefghhgfedecba,YES",
        "abbcccddd,NO",
        "a,YES",
        "aaaccccccc,NO",
        "aabbccddeef,YES",
        "aaabbbcdf,NO"
    ])
    fun isValid(string: String, result: String) {
        assertThat(isValid(string))
            .`as`("is '%s' considered valid by Shelock?", string)
            .isEqualTo(result)
    }

    @Test
    fun isValidModuleTest() {
        moduleTest("abcdefghhgfedecba", ::main) {
            verify { print("YES") }
        }
    }
}
