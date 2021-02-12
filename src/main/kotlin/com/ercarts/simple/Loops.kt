package com.ercarts.simple

/**
 * @author dkyryk
 */
fun main() {
    for (colour in Rgb.values()) {
        println(colour.name)
    }
}


private enum class Rgb {
    RED, GREEN, BLUE
}
