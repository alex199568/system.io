package io.system

import java.math.BigInteger
import kotlin.math.pow

data class Rational(
    private var nominator: BigInteger = BigInteger.ZERO,
    private var denominator: BigInteger = BigInteger.ONE
) {

    private var negative = false

    private val signedNominator: BigInteger
        get() {
            return if (negative) -nominator else nominator
        }

    constructor(
        nominator: Int = 0,
        denominator: Int = 1
    ) : this(
        nominator.toBigInteger(),
        denominator.toBigInteger()
    )

    constructor(
        nominator: Long = 0L,
        denominator: Long = 1L
    ) : this(
        nominator.toBigInteger(),
        denominator.toBigInteger()
    )

    constructor(f: Float = 0f) : this(
        (f * 10.0.pow(f.decimalPlaces)).toBigInt(),
        10.0.pow(f.decimalPlaces).toBigInt()
    )

    constructor(d: Double = 0.0) : this(
        (d * 10.0.pow(d.decimalPlaces)).toBigInt(),
        10.0.pow(d.decimalPlaces).toBigInt()
    )

    init {
        require(denominator != BigInteger.ZERO)

        negative = if (nominator >= BigInteger.ZERO && denominator >= BigInteger.ZERO) {
            false
        } else if (nominator < BigInteger.ZERO && denominator < BigInteger.ZERO) {
            false
        } else {
            true
        }

        nominator = nominator.abs()
        denominator = denominator.abs()

        val gcd = gcd(nominator, denominator)
        nominator /= gcd
        denominator /= gcd
    }

    override fun toString(): String {

        if (denominator == BigInteger.ONE) {
            if (negative) return "-$nominator"
            return nominator.toString()
        }

        var result = ""
        val whole = nominator / denominator
        if (whole == BigInteger.ZERO) {
            result = "$nominator/$denominator"
        } else {
            val part = nominator - whole * denominator
            result = "$whole $part/$denominator"
        }
        if (negative) return "-($result)"
        return result
    }

    fun toFloat(): Float {
        val result = nominator.toFloat() / denominator.toFloat()
        if (negative) return -result
        return result
    }

    fun toDouble(): Double {
        val result = nominator.toDouble() / denominator.toDouble()
        if (negative) return -result
        return result
    }

    operator fun unaryMinus(): Rational {
        return Rational(-nominator, denominator)
    }

    operator fun plus(r: Rational): Rational {
        if (denominator == r.denominator) {
            return Rational(signedNominator + r.signedNominator, denominator)
        }

        val n1 = signedNominator * r.denominator
        val n2 = r.signedNominator * denominator
        val d = denominator * r.denominator

        return Rational(n1 + n2, d)
    }

    operator fun plus(i: Int): Rational {
        return this + Rational(i)
    }

    operator fun plus(l: Long): Rational {
        return this + Rational(l)
    }

    operator fun plus(f: Float): Rational {
        return this + Rational(f)
    }

    operator fun plus(d: Double): Rational {
        return this + Rational(d)
    }

    operator fun minus(r: Rational): Rational {
        if (denominator == r.denominator) {
            return Rational(signedNominator - r.signedNominator, denominator)
        }

        val n1 = signedNominator * r.denominator
        val n2 = r.signedNominator * denominator
        val d = denominator * r.denominator

        return Rational(n1 - n2, d)
    }

    operator fun minus(i: Int): Rational {
        return this - Rational(i)
    }

    operator fun minus(l: Long): Rational {
        return this - Rational(l)
    }

    operator fun minus(f: Float): Rational {
        return this - Rational(f)
    }

    operator fun minus(d: Double): Rational {
        return this - Rational(d)
    }

    operator fun times(r: Rational): Rational {
        return Rational(signedNominator * r.signedNominator, denominator * r.denominator)
    }

    operator fun times(i: Int): Rational {
        return Rational(signedNominator * i.toBigInteger(), denominator)
    }

    operator fun times(l: Long): Rational {
        return Rational(signedNominator * l.toBigInteger(), denominator)
    }

    operator fun times(f: Float): Rational {
        return this * Rational(f)
    }

    operator fun times(d: Double): Rational {
        return this * Rational(d)
    }

    operator fun div(r: Rational): Rational {
        return this * Rational(r.denominator, r.signedNominator)
    }

    operator fun div(i: Int): Rational {
        return this * Rational(1, i)
    }

    operator fun div(l: Long): Rational {
        return this * Rational(1, l)
    }

    operator fun div(f: Float): Rational {
        return this / Rational(f)
    }

    operator fun div(d: Double): Rational {
        return this / Rational(d)
    }

    companion object {

        private fun gcd(n: BigInteger, d: BigInteger): BigInteger {
            if (d == BigInteger.ZERO) return n
            return gcd(d, n % d)
        }
    }
}
