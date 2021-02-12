package com.ercarts.simple

import kotlin.random.Random

/**
 * @author dkyryk
 */
fun main() {

    val a = 10
    val b = Random.nextInt(0, 30)

    val result = if (a > b) "Random lesser" else "Random bigger"
    println("b = $b $result than $a")

    val rng = Random.nextInt(36)
    val dozenName = when (rng) {
        in (0..12) -> "First"
        in (13..24) -> "Second"
        else -> "Third"
    }
    println("rng = $rng at dozen $dozenName")

    val nullString: String? = nullableString()

    val length = nullString?.length ?: 0

    println("String $nullString length $length")

}

fun nullableString(): String? {
    val rng = Random.nextInt(0, 10)
    return if (rng % 2 == 0) {
        "Value"
    } else {
        null
    }
}