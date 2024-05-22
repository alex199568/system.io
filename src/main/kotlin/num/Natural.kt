package io.system.num

import java.math.BigInteger

class Natural() : Comparable<Natural> {

    private var value: BigInteger = BigInteger.ONE

    constructor(i: Int) : this() {
        require(i > 0)
        value = BigInteger.valueOf(i.toLong())
    }

    constructor(l: Long) : this() {
        require(l > 0L)
        value = BigInteger.valueOf(l)
    }

    constructor(bi: BigInteger) : this() {
        require(bi > BigInteger.ZERO)
        value = bi
    }

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Natural

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    operator fun plus(n: Natural): Natural {
        return Natural(value + n.value)
    }

    operator fun minus(n: Natural): Natural {
        return Natural(value - n.value)
    }

    operator fun times(n: Natural): Natural {
        return Natural(value * n.value)
    }

    operator fun div(n: Natural): Natural {
        return Natural(value / n.value)
    }

    operator fun rem(n: Natural): Natural {
        return Natural(value % n.value)
    }

    override fun compareTo(other: Natural): Int {
        return value.compareTo(other.value)
    }

    companion object {

        val one = Natural(1)

        @JvmStatic
        fun main(args: Array<String>) {
            sequence.take(10).forEach { println(it) }
        }

        val sequence = generateSequence(one) { it + one }
    }
}
