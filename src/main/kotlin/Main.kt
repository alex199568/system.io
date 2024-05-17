package io.system

fun main() {
    val v = V(1, 2, 3) * 3.2
    val v2 = V(2, 3, 4, 1) / 0.7
    val result = -v + v2
    println(result.unit.length)
}
