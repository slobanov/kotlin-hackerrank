package ru.amai.study.hackerrank.practice.interviewPreparationKit.greedy.reverseShuffleMerge

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class ReverseShuffleMergeKtTest {

    @ParameterizedTest
    @CsvSource(value = [
        "eggegg,egg",
        "abcdefgabcdefg,agfedcb",
        "aeiouuoiea,aeiou",
        "bdabaceadaedaaaeaecdeadababdbeaeeacacaba,aaaaaabaaceededecbdb"
    ])
    fun reverseShuffleMergeTest(string: String, smallestA: String) {
        assertThat(reverseShuffleMerge(string))
            .`as`("smallest string A such as '%s' = merge(reverse(A) + shuffle(A))")
            .isEqualTo(smallestA)
    }

    @Test
    fun reverseShuffleMergeModuleTest() {
        moduleTest("""
            eggegg
        """.trimIndent(), ::main) {
            verify { print("egg") }
        }
    }
}
