package com.ercarts.simple

/**
 * @author dkyryk
 */

interface Point {
    fun coordinates(): String {
        return "Default logic! coordinates unknown"
    }
}

class PointA internal constructor(x: Int, y: Int) : Point {

    val x = x
    val y = y

    internal constructor(i: Int) : this(i, i) {
        println("Same coordinates constructor")
    }

    init {
        println("Init a")
    }

    override fun coordinates(): String {
        return "$x, $y"
    }
}

class PointB(private val x: Int, private val y: Int) : Point {
    override fun coordinates(): String {
        return "x = $x, y = $y"
    }
}

data class PointC(private val x: Int, private val y: Int) : Point {
    override fun coordinates(): String = "dx=$x|dy=$y"
}

class PointD private constructor(private val x: Int, private val y: Int) : Point {

    internal companion object Factory {
        fun newInstance(x: Int, y: Int): Point {
            return PointD(x, y)
        }
    }
}

fun main() {
    val a = PointA(1, 0)
    val a1 = PointA(1)
    val b = PointB(3, 5)
    val c = PointC(6, 7)
    val cCopy = c.copy(x = 8)
    val cEqualsCopy = c.copy()
    val d = PointD.newInstance(8,234)

    listOf(a, a1, b, c, cCopy, cEqualsCopy, d)
        .forEach {
            println("HC = ${it.hashCode()} | toS = ${it.toString()} | coordinates = ${it.coordinates()}")
        }

}