package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.swap

import java.util.*

fun swapNodes(indexes: Array<Array<Int>>, queries: Array<Int>): List<List<Int>> {
    val root = buildTree(indexes)

    return queries.map { swapMultiplier ->
        val queryResult = mutableListOf<Int>()
        traverseInOrderWithSwaps(root, swapMultiplier) { node ->
            queryResult += node.index
        }
        queryResult
    }
}

private fun traverseInOrderWithSwaps(
    node: Node,
    swapMultiplier: Int,
    level: Int = 1,
    observer: (Node) -> Unit
) {
    if (level % swapMultiplier == 0) node.swapSubTrees()

    val (_, left, right) = node
    left?.let { traverseInOrderWithSwaps(left, swapMultiplier, level + 1, observer) }
    observer(node)
    right?.let { traverseInOrderWithSwaps(right, swapMultiplier, level + 1, observer) }
}

private fun buildTree(indexes: Array<Array<Int>>): Node {
    val nodeMap = mutableMapOf<Int, Node>()
    indexes.forEachIndexed { i, (l, r) ->
        val p = i + 1
        listOf(p, l, r)
            .filter { it != -1 }
            .forEach { nodeMap.putIfAbsent(it, Node(it)) }

        if (l != -1) nodeMap.getValue(p).left = nodeMap.getValue(l)
        if (r != -1) nodeMap.getValue(p).right = nodeMap.getValue(r)
    }
    return nodeMap.getValue(1)
}

private data class Node(
    val index: Int,
    var left: Node? = null,
    var right: Node? = null
)

private fun Node.swapSubTrees() {
    val tmp = left
    left = right
    right = tmp
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val indexes = Array(n) { Array(2) { 0 } }

    for (indexesRowItr in 0 until n) {
        indexes[indexesRowItr] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val queriesCount = scan.nextLine().trim().toInt()

    val queries = Array(queriesCount) { 0 }
    for (queriesItr in 0 until queriesCount) {
        val queriesItem = scan.nextLine().trim().toInt()
        queries[queriesItr] = queriesItem
    }

    val result = swapNodes(indexes, queries)

    println(result.joinToString("\n") { it.joinToString(" ") })
}
