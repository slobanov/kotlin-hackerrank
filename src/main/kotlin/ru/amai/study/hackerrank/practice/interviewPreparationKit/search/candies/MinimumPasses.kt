package ru.amai.study.hackerrank.practice.interviewPreparationKit.search.candies

import java.math.BigDecimal
import java.math.BigDecimal.ONE
import java.math.BigDecimal.ZERO
import java.math.BigDecimal.valueOf
import java.math.RoundingMode.CEILING
import java.math.RoundingMode.FLOOR
import java.util.*

fun minimumPasses(machines: Long, workers: Long, price: Long, targetCnt: Long): Long {
    var currentCandies = ZERO
    var days = ZERO

    val priceDecimal = price.toBigDecimal()
    val targetDecimal = targetCnt.toBigDecimal()

    var factoryResources = FactoryResources(
        valueOf(workers),
        valueOf(machines)
    )
    while (currentCandies < targetDecimal) {
        val produced = factoryResources.production
        currentCandies += produced

        val (newResources, cost) = investPlan(
            factoryResources,
            currentCandies,
            priceDecimal
        )

        val waitIfStore =
            (targetDecimal - currentCandies).divide(produced, CEILING)

        if (cost > ZERO) {
            val waitIfInvest =
                (targetDecimal - currentCandies + cost).divide((newResources.production), CEILING)

            if ((waitIfStore > ZERO) && (waitIfInvest <= waitIfStore)) {
                factoryResources = newResources
                currentCandies -= cost
                days++
            } else {
                days += (waitIfStore + ONE)
                currentCandies = targetDecimal
            }
        } else {
            val waitToInvest = (priceDecimal - currentCandies).divide(produced, CEILING)

            if (waitIfStore <= waitToInvest) {
                days += (waitIfStore + ONE)
                currentCandies = targetDecimal
            } else {
                days += waitToInvest
                currentCandies += produced * (waitToInvest - ONE)
            }
        }
    }

    return days.toLong()
}

private data class FactoryResources(
    val workers: BigDecimal,
    val machines: BigDecimal
)

private val FactoryResources.production: BigDecimal
    get() = workers * machines

private data class InvestPlan(
    val factoryResources: FactoryResources,
    val cost: BigDecimal
)

private val TWO = valueOf(2)

private fun investPlan(factoryResources: FactoryResources, candies: BigDecimal, price: BigDecimal): InvestPlan {
    val (currentWorkers, currentMachines) = factoryResources

    val canBuy = candies.divide(price, FLOOR)

    val diff = (currentMachines - currentWorkers).abs()
    val toBuyForBalance = diff.min(canBuy)
    val leftToBuy = canBuy - toBuyForBalance

    var newMachines = currentMachines
    var newWorkers = currentWorkers

    if (currentMachines > currentWorkers) {
        newWorkers += toBuyForBalance
    } else if (currentWorkers > currentMachines) {
        newMachines += toBuyForBalance
    }

    if (newMachines == newWorkers) {
        newMachines += leftToBuy.divide(TWO, FLOOR)
        newWorkers += leftToBuy.divide(TWO, CEILING)
    }

    val cost = ((newMachines - currentMachines) + (newWorkers - currentWorkers)) * price

    return InvestPlan(
        FactoryResources(newWorkers, newMachines),
        cost
    )
}

fun main() {
    val scan = Scanner(System.`in`)

    val (machines, workers, price, targetCnt) =
        scan.nextLine().split(" ").map { it.trim().toLong() }

    val result = minimumPasses(machines, workers, price, targetCnt)
    println(result)
}
