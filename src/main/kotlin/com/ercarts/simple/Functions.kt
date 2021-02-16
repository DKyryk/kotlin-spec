package com.ercarts.simple

import kotlin.random.Random

/**
 * @author dkyryk
 */

fun main() {
    println(simpleFunctionDefaultSuffix(base = "defaultSuffix? "))

    tryFunctions(::simpleFunction)
    tryFunctions(::simpleFunctionOneLine)

    val lambda: (String, String) -> String = { base: String, suffix: String ->
        println("Lambda called")
        base + suffix
    }

    tryFunctions(lambda)
    val shortLambda = { base: String, suffix: String ->
        println("Short lambda called")
        base + suffix
    }
    tryFunctions(shortLambda)

    val addSuffix: String.(String) -> String = {
        suffix -> this + suffix
    }

    val addChar: Char.(Char) -> String = { suffix -> "$this$suffix"}

    println('a'.addChar('b'))
    println("base".addSuffix("Suffix"))

    println("Rng nulls")
    (1..5).forEach{ _ ->
        println("${handleNull()} | ${letUsage()}")
    }
}

private fun tryFunctions(operation: (base: String, suffix: String) -> String) {
    val a = operation("abs", "+")
    val b = operation("abs2", "-")
    println("$a|$b")
}

private fun simpleFunction(base: String, suffix: String): String {
    return base + suffix
}

private fun simpleFunctionOneLine(base: String, suffix: String): String = base + suffix

private fun simpleFunctionDefaultSuffix(base: String, suffix: String = "Yes") = base + suffix

private fun randomNull(): String? {
    val rng = Random.nextInt(0, 30)
    return if (rng % 2 == 0) "Blank" else null
}

private fun handleNull() = randomNull() ?: "null"

private fun letUsage() = randomNull()?.let { "$it Let" } ?: "null Let"