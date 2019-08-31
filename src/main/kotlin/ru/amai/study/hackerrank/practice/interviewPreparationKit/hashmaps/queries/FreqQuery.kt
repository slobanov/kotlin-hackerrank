package ru.amai.study.hackerrank.practice.interviewPreparationKit.hashmaps.queries

private const val INSERT = 1
private const val REMOVE = 2
private const val CHECK = 3

private const val SET_INIT_SIZE = 1000
private const val LOAD_FACTOR = 0.5f

fun freqQuery(queries: Array<IntArray>): List<Int> {
    val valueToCnt = mutableMapOf<Int, Int>()
    val cntToValues = mutableMapOf<Int, MutableSet<Int>>()

    val checkResults = mutableListOf<Int>()
    fun executeQuery(query: Int, value: Int) {
        when(query) {
            INSERT -> insert(value, valueToCnt, cntToValues)
            REMOVE -> remove(value, valueToCnt, cntToValues)
            CHECK -> {
                val checkResult = check(value, cntToValues)
                checkResults += checkResult
            }
        }
    }

    queries.forEach { (query, value) -> executeQuery(query, value) }

    return checkResults
}

private fun insert(value: Int, valueToCnt: MutableMap<Int, Int>, cntToValues: MutableMap<Int, MutableSet<Int>>) {
    val currCnt = valueToCnt.getOrDefault(value, 0)
    val newCnt = currCnt + 1
    valueToCnt[value] = newCnt
    cntToValues.getOrPut(newCnt) { HashSet(SET_INIT_SIZE, LOAD_FACTOR) } += value
    if (currCnt != 0) {
        cntToValues.getValue(currCnt) -= value
    }
}


private fun remove(value: Int, valueToCnt: MutableMap<Int, Int>, cntToValues: MutableMap<Int, MutableSet<Int>>) {
    if (value in valueToCnt) {
        val currCnt = valueToCnt.getValue(value)
        val newCnt = currCnt - 1
        cntToValues.getValue(currCnt) -= value
        if (newCnt != 0) {
            valueToCnt[value] = newCnt
            cntToValues.getOrPut(newCnt) { mutableSetOf() } += value
        } else {
            valueToCnt -= value
        }
    }
}

private fun check(value: Int, cntToValues: MutableMap<Int, MutableSet<Int>>) =
    if (cntToValues[value]?.isNotEmpty() == true) { 1 } else { 0 }

fun main() {
    val q = readLine()!!.trim().toInt()
    val queries = Array(q) { IntArray(2) { 0 } }

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toIntArray()
    }

    val ans = freqQuery(queries)
    println(ans.joinToString("\n"))
}
