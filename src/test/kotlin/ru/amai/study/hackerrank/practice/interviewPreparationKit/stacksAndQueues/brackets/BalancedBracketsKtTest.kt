package ru.amai.study.hackerrank.practice.interviewPreparationKit.stacksAndQueues.brackets

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class BalancedBracketsKtTest {

    @ParameterizedTest
    @CsvSource(
        "()",
        "[]",
        "[]",
        "([])",
        "{[[]]()()}"
    )
    fun isBalancedYesTest(s: String) {
        assertThat(s).matches({ isBalanced(it) == "YES" }, "is balanced")
    }

    @ParameterizedTest
    @CsvSource(
        "(]",
        "{]",
        "[)",
        "([{])",
        "{[[]()()}"
    )
    fun isBalancedNoTest(s: String) {
        assertThat(s).matches({ isBalanced(it) == "NO" }, "is not balanced")
    }

    @Test
    fun isBalancedErrorTest() {
        assertThat(catchThrowable { isBalanced("abc") })
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun isBalancedModuleTest() {
        moduleTest("""
            3
            {[()]}
            {[(])}
            {{[[(())]]}}
        """.trimIndent(), ::main) {
            verify {
                print("YES")
                print("NO")
                print("YES")
            }
        }
    }
}
