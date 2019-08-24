package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.strings

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class TwoStringsKtTest {

    @ParameterizedTest
    @CsvSource(
        "hello,world,YES",
        "hi,world,NO"
    )
    fun twoStringsTest(s1: String, s2: String, result: String) {
        assertThat(twoStrings(s1, s2))
            .`as`("Is '%s' and '%s' share a common substring?", s1, s2)
            .isEqualTo(result)
    }

    @Test
    fun twoStringsModuleTest() {
        moduleTest("""
            2
            hello
            world
            hi
            world
        """.trimIndent(),
            ::main) {
            verify {
                print("YES")
                print("NO")
            }
        }
    }
}
