package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.iceCream

import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.amai.study.hackerrank.practice.interviewPreparationKit.moduleTest

internal class WhatFlavorsKtTest {

    @ParameterizedTest
    @MethodSource("costProvider")
    fun whatFlavorsTest(cost: IntArray, money: Int, result: String) {
        assertThat(whatFlavors(cost, money))
            .`as`("indices for the flavors to purchase from '%s' given '%s' money",
                cost.contentToString(),
                money
            ).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun costProvider() = listOf(
            of(intArrayOf(1, 4, 5, 3, 2), 4, "1 4"),
            of(intArrayOf(2, 2, 4, 3), 4, "1 2")
        )
    }

    @Test
    fun whatFlavorsModuleTest() {
        moduleTest("""
            2
            4
            5
            1 4 5 3 2
            4
            4
            2 2 4 3
        """.trimIndent(), ::main) {
            verify {
                print("1 4\n1 2")
            }
        }
    }
}
