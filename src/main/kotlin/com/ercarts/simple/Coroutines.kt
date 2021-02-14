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
    measureTime(name = "launch", call = ::launchCall)
    backgroundLaunch()

    runBlocking {
        println("Waiting till background finished")
        delay(3000)
    }
}
fun backgroundLaunch() {
    val count = 5
    val name = "launchBackground"

    GlobalScope.launch {
        wrapCall(name) {
            runBlocking {
                val time = measureTimeMillis {
                    (1..count).map {
                        async {
                            randomDelay()
                        }
                    }.awaitAll()
                }
                timeTaken(count, name, time)
            }
        }
    }

}

fun timeTaken(count: Int, name: String, time: Long) {
    println("$count calls to $name took: $time milliseconds")
}

fun measureTime(name: String, count: Int = 5, call: (Int) -> Unit) {
    wrapCall(name = name) {
        val time = measureTimeMillis {
            call(count)
        }
        timeTaken(count, name, time)
    }
}

fun wrapCall(name: String, call: () -> Unit) {
    println("-------------------------------------------------------------")
    println("$name execution")
    call()
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

fun launchCall(count: Int) = runBlocking {
    (1..count).map {
        launch(Dispatchers.Default) {
            randomDelay()
        }
    }
}

suspend fun randomDelay() {

    val delayMs = Random.nextLong(500, 1500)
    delay(delayMs)
    println("Executed in ${Thread.currentThread().name} and waited $delayMs milliseconds")
}