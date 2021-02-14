package com.ercarts.simple

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * @author dkyryk
 */
fun main() {

    measureTime(name = "sync", call = ::syncCall)
    measureTime(name = "async", call = ::asyncCall)
}

fun measureTime(name: String, count: Int = 5, call: (Int) -> Unit) {
    println("-------------------------------------------------------------")
    println("$name execution")
    val time = measureTimeMillis {
        call(count)
    }
    println("$count calls to $name took: $time milliseconds")
    println("-------------------------------------------------------------")
}


fun asyncCall(count: Int) = runBlocking {
    (1..count).map {
        async {
            randomDelay()
        }
    }.awaitAll()
}

fun syncCall(count: Int) = runBlocking {
    (1..count).map {
        randomDelay()
    }
}

suspend fun randomDelay() {
    val delayMs = Random.nextLong(500, 1500)
    delay(delayMs)
    println("Waited $delayMs milliseconds")
}