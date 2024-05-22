package io.system

import java.math.BigInteger

class Whole(

) : Comparable<Whole> {

    private var value: BigInteger = BigInteger.ZERO

    constructor(i: Int) : this() {
        require(i >= 0)
        value = BigInteger.valueOf(i.toLong())
    }

    constructor(l: Long) : this() {
        require(l >= 0L)
        value = BigInteger.valueOf(l)
    }

    constructor(bi: BigInteger) : this() {
        require(bi >= BigInteger.ZERO)
        value = bi
    }

    override fun toString(): String {
        return value.toString()
    }

    override operator fun compareTo(other: Whole): Int {
        return value.compareTo(other.value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Whole

        return value == other.value
    }

    operator fun plus(w: Whole): Whole {
        return Whole(value + w.value)
    }

    operator fun minus(w: Whole): Whole {
        return Whole(value - w.value)
    }

    operator fun times(w: Whole): Whole {
        return Whole(value * w.value)
    }

    operator fun div(w: Whole): Whole {
        return Whole(value / w.value)
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    operator fun inc(): Whole {
        return this + one
    }

    operator fun dec(): Whole {
        return this - one
    }

    companion object {

        val zero = Whole(0)
        val one = Whole(1)

        @JvmStatic
        fun main(args: Array<String>) {

        }

        val sequence: Sequence<Whole> = generateSequence(zero) { it + one }

    }
}
