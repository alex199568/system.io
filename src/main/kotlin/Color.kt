package io.system

import io.system.num.Rational

data class Color(
    val r: Rational = Rational(0),
    val g: Rational = Rational(0),
    val b: Rational = Rational(0),
    val a: Rational = Rational(1, 1)
) {

    constructor(
        r: Double, g: Double, b: Double, a: Double = 1.0
    ) : this(
        Rational(r),
        Rational(g),
        Rational(b),
        Rational(a)
    )
}
