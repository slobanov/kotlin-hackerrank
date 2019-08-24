package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.magazine

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest
import java.util.Arrays.toString

internal class CheckMagazineKtTest {

    @ParameterizedTest
    @MethodSource("arraysProvider")
    fun checkMagazineTest(magazine: Array<String>, note: Array<String>, result: String) {
        assertThat(checkMagazine(magazine, note))
            .`as`("Can use the magazine  %s to create an untraceable replica of his ransom note %s?",
                toString(magazine), toString(note))
            .isEqualTo(result)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun arraysProvider() = listOf(
            of(
                arrayOf("give", "me", "one", "grand", "today", "night"),
                arrayOf("give", "me", "one", "grand", "today"),
                "Yes"
            ),
            of(
                arrayOf("ive", "got", "a", "lovely", "bunch", "of", "coconuts"),
                arrayOf("ive", "got", "some", "coconuts"),
                "No"
            ),
            of(
                arrayOf("ive", "got", "a", "lovely", "bunch", "of", "coconuts"),
                arrayOf("ive", "got", "got"),
                "No"
            )
        )
    }

    @Test
    fun checkMagazineModuleTest() {
        moduleTest("""
                6 4
                give me one grand today night
                give one grand today
        """.trimIndent(),
            ::main) {
            verify { print("Yes") }
        }
    }
}
