package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.candies

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class MinimumPassesKtTest {

    @ParameterizedTest
    @CsvSource(value = [
        "3, 1, 2, 12, 3",
        "1, 1, 6, 45, 16",
        "5184889632, 5184889632, 20, 10000, 1",
        "1, 1, 1000000000000, 1000000000000, 1000000000000",
        "28, 81, 64143, 93888052920, 2449"
    ])
    fun minimumPassesTest(machines: Long, workers: Long, price: Long, targetCnt: Long, result: Long) {
        assertThat(minimumPasses(machines, workers, price, targetCnt))
            .`as`("""
                min days to produce '%s' candies, 
                starting with workers = '%s' and machines = '%s' with price to upgrade = '%s'"
            """.trimIndent(),
                targetCnt,
                workers,
                machines,
                price
            ).isEqualTo(result)
    }

    @Test
    fun minimumPassesModuleTest() {
        moduleTest("""
            3 1 2 12
        """.trimIndent(), ::main) {
            verify { println(3L) }
        }
    }
}
