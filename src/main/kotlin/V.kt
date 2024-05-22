package io.system

import io.system.num.Rational
import kotlin.math.sqrt

class V(
    private val elements: List<Rational> = emptyList()
) {

    operator fun get(i: Int): Rational {
        if (i in elements.indices) return elements[i]
        return Rational(0)
    }

    constructor(vararg numbers: Number) : this(
        numbers.map { Rational(it.toDouble()) }
    )

    val x: Rational
        get() {
            return this[0]
        }

    val y: Rational
        get() {
            return this[1]
        }

    val z: Rational
        get() {
            return this[2]
        }

    val w: Rational
        get() {
            return this[3]
        }

    operator fun unaryMinus(): V {
        return V(elements.map { -it })
    }

    operator fun times(n: Number): V {
        val f = n.toDouble()
        return V(elements.map { it * f })
    }

    operator fun div(n: Number): V {
        val f = n.toDouble()
        return V(elements.map { it / f })
    }

    operator fun div(r: Rational): V {
        return V(elements.map { it / r })
    }

    operator fun plus(v: V): V {
        return combine(this, v) { f1, f2 -> f1 + f2 }
    }

    operator fun minus(v: V): V {
        return combine(this, v) { f1, f2 -> f1 - f2 }
    }

    val length: Rational
        get() {
            return Rational(sqrt(elements.sumOf { (it * it).toDouble() }))
        }

    val unit: V
        get() {
            return this / length
        }

    override fun toString(): String {

        if (elements.isEmpty()) {
            return "v0()"
        }

        if (elements.size == 1) {
            return "v${elements.size}(x=${this[0]})"
        }

        if (elements.size == 2) {
            return "v${elements.size}(x=${this[0]}, y=${this[1]})"
        }

        if (elements.size == 3) {
            return "v${elements.size}(x=${this[0]}, y=${this[1]}, z=${this[2]})"
        }

        if (elements.size == 4) {
            return "v${elements.size}(x=${this[0]}, y=${this[1]}, z=${this[2]}, w=${this[3]})"
        }

        return buildString {
            append("v${elements.size}(")
            append("x=${this@V[0]}, ")
            append("y=${this@V[1]}, ")
            append("z=${this@V[2]}, ")
            append("w=${this@V[3]}, ...)")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as V

        return elements == other.elements
    }

    override fun hashCode(): Int {
        return elements.hashCode()
    }

    companion object {


        private fun combine(v1: V, v2: V, f: (Rational, Rational) -> Rational): V {
            val newElements = mutableListOf<Rational>()

            if (v1.elements.size > v2.elements.size) {
                v1.elements.forEachIndexed { index, fl ->
                    newElements += f(fl, v2[index])
                }
            } else {
                v2.elements.forEachIndexed { index, fl ->
                    newElements += f(v1[index], fl)
                }
            }

            return V(newElements)
        }
    }
}
