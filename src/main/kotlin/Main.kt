package io.system

fun main() {
    val r = Rational(2, 3)
    val result = r / 2.5
    println(r)
    println(r.toDouble())
    println(result)
    println(result.toDouble())
    println(r.toDouble() / 2.5)
}
