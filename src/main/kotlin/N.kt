package io.system

import java.math.BigInteger



fun Double.toBigInt(): BigInteger {
    return toLong().toBigInteger()
}

val evenSequence: Sequence<Rational> = generateSequence(Rational(2)) { it + 2 }
val oddSequence: Sequence<Rational> = generateSequence(Rational(1)) { it + 2 }

fun main() {
    evenSequence.take(10).forEach { println(it) }
    println("---")
    oddSequence.take(10).forEach { println(it) }
}
