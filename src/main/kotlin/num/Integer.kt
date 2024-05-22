package io.system.num

import java.math.BigInteger

class Integer() : Comparable<Integer> {

    private var value: BigInteger = BigInteger.ZERO

    constructor(i: Int) : this() {
        value = BigInteger.valueOf(i.toLong())
    }

    constructor(l: Long) : this() {
        value = BigInteger.valueOf(l)
    }

    constructor(bi: BigInteger) : this() {
        value = bi
    }

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Integer

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    operator fun plus(i: Integer): Integer {
        return Integer(value + i.value)
    }

    operator fun minus(i: Integer): Integer {
        return Integer(value - i.value)
    }

    operator fun times(i: Integer): Integer {
        return Integer(value * i.value)
    }

    operator fun div(i: Integer): Integer {
        return Integer(value / i.value)
    }

    override operator fun compareTo(other: Integer): Int {
        return value.compareTo(other.value)
    }

    val isNatural: Boolean
        get() {
            return this >= one
        }

    val isWhole: Boolean
        get() {
            return this >= zero
        }

    companion object {

        val zero = Integer(0)
        val one = Integer(1)
        val minusOne = Integer(-1)

        @JvmStatic
        fun main(args: Array<String>) {
            negative.take(10).forEach { println(it) }
        }

        val positive: Sequence<Integer> = generateSequence(zero) { it + one }
        val negative: Sequence<Integer> = generateSequence(zero) { it + minusOne }
    }
}
