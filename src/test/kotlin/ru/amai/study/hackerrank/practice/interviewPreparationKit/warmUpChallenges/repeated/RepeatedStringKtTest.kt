package ru.amai.study.hackerrank.practice.interviewPreparationKit.warmUpChallenges.repeated

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class RepeatedStringKtTest {

    @ParameterizedTest
    @CsvSource(
        "aba,10,7",
        "a,1000000000000,1000000000000",
        "absadas,0,0",
        "'',0,0"
    )
    fun repeatedStringTest(str: String, charCnt: Long, numberOfA: Long) {
        assertThat(repeatedString(str, charCnt))
            .`as`(
                "number of letter a's in the first %s letters of '%s', repeated infinitely many times.",
                charCnt,
                str
            ).isEqualTo(numberOfA)
    }

    @Test
    fun repeatedStringModuleTest() {
        moduleTest("aba${System.lineSeparator()}10", ::main) {
            verify { println(7L) }
        }
    }
}
