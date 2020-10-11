package ru.amai.study.hackerrank.practice.interviewPreparationKit.stacksAndQueues.brackets

import java.util.*

private val OpeningBraceByClosing = mapOf(
    '}' to '{',
    ')' to '(',
    ']' to '['
)

private val AllPossibleBraces = OpeningBraceByClosing.toList()
    .flatMap { (close, open) -> listOf(open, close) }

fun isBalanced(s: String): String {
    require(s.all { it in AllPossibleBraces }) {
        "input string must contain only braces from '${AllPossibleBraces.joinToString()}'; Got '$s'"
    }

    val stack = Stack<Char>()

    fun canPop(brace: Char): Boolean =
        (stack.isNotEmpty()) && (stack.peek() == OpeningBraceByClosing[brace])

    s.forEach { brace ->
        if (canPop(brace)) stack.pop()
        else stack.push(brace)
    }

    return if (stack.isEmpty()) "YES" else "NO"
}

fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    repeat(t) {
        val s = scan.nextLine()
        val result = isBalanced(s)
        println(result)
    }
}
