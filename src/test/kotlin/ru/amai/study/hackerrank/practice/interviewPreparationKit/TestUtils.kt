package ru.amai.study.hackerrank.practice.interviewPreparationKit

import io.mockk.every
import io.mockk.mockkConstructor
import io.mockk.spyk
import java.io.PrintStream
import java.util.*

fun moduleTest(input: String, main: () -> Unit, block: PrintStream.() -> Unit) {
    val scanner = Scanner(input)
    mockkConstructor(Scanner::class)
    every {
        anyConstructed<Scanner>().nextLine()
    } answers { scanner.nextLine() }

    val outSpy = spyk(System.out)
    System.setOut(outSpy)

    main()

    outSpy.block()
}
