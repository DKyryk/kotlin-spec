package com.ercarts.simple

import kotlin.random.Random

/**
 * @author dkyryk
 */
fun main() {
    arrays()
}

private fun arrays() {
    val nonHomogenous = arrayOf(0, 1, "three")
//    won't compile
//    nonHomogenous.set(0, "zero")
//    nonHomogenous[0] = "zero"

    val homogenous = arrayOf(0, 1, 2)
    homogenous[0] = -1

    for (elem in nonHomogenous) {
        print(" $elem ")
    }
    println()

    for (elem in homogenous) {
        print(" $elem ")
    }
    println()
    val rngInts = Array(10, ::randomizer)
    rngInts.forEach { print(" $it ") }
}

private fun randomizer(index: Int): Int {
    return Random.nextInt(index, 10)
}