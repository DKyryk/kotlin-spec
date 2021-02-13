package com.ercarts.simple

import java.util.*
import kotlin.collections.HashSet
import kotlin.random.Random

/**
 * @author dkyryk
 */
fun main() {
    arrays()
    lists()
    sets()
}

private fun lists() {
    runOperationOnNewLine {
        val words = listOf("Don't", "be", "sorry.", "Be", "better.")
        println(words.joinToString(separator = " "))
    }

    runOperationOnNewLine {
        val cheating = mutableListOf("Cake", "is", "a", "lie")
        cheating.removeAt(cheating.lastIndex)
        cheating.add("truth")
        println(cheating.joinToString(separator = " "))
    }
}

private fun sets() {
    runOperationOnNewLine {
        val uniqueWords = TreeSet<String>()
        uniqueWords.add("the")
        uniqueWords.add("the")
        uniqueWords.add("great")
        uniqueWords.add("great")
        uniqueWords.add("great")
        uniqueWords.add("one")

        println(uniqueWords.joinToString(separator = " "))
    }
}

private fun arrays() {

    runOperationOnNewLine {
        val nonHomogenous = arrayOf(0, 1, "three")
        //    won't compile
        //    nonHomogenous.set(0, "zero")
        //    nonHomogenous[0] = "zero"
        for (elem in nonHomogenous) {
            print(" $elem ")
        }
    }

    runOperationOnNewLine {
        val homogenous = arrayOf(0, 1, 2)
        homogenous[0] = -1
        for (elem in homogenous) {
            print(" $elem ")
        }
    }

    runOperationOnNewLine {
        val rngInts = Array(10, ::randomizer)
        rngInts.forEach { print(" $it ") }
    }

    runOperationOnNewLine {
        val intArray = intArrayOf(3, 4, 5)
        intArray.forEach { print(" $it ") }
    }
}

private fun runOperationOnNewLine(operation: () -> Unit) {
    println()
    operation()
}

private fun randomizer(index: Int): Int {
    return Random.nextInt(index, 10)
}