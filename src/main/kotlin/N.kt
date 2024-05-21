package io.system

import java.math.BigInteger



fun Double.toBigInt(): BigInteger {
    return toLong().toBigInteger()
}

val evenSequence: Sequence<Rational> = generateSequence(Rational(2)) { it + 2 }
val oddSequence: Sequence<Rational> = generateSequence(Rational(1)) { it + 2 }
val positiveSequence: Sequence<Rational> = generateSequence(Rational(0)) { it + 1 }
val squareSequence: Sequence<Rational> = positiveSequence.map { it * it }

fun main() {
    squareSequence.take(10).forEach { println(it) }
}
