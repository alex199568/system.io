package io.system

import kotlin.math.sqrt

class V(
    private val elements: List<Float> = emptyList()
) {

    operator fun get(i: Int): Float {
        if (i in elements.indices) return elements[i]
        return 0f
    }

    constructor(vararg numbers: Number) : this(
        numbers.map { it.toFloat() }
    )

    val x: Float
        get() {
            return this[0]
        }

    val y: Float
        get() {
            return this[1]
        }

    val z: Float
        get() {
            return this[2]
        }

    val w: Float
        get() {
            return this[3]
        }

    operator fun unaryMinus(): V {
        return V(elements.map { -it })
    }

    operator fun times(n: Number): V {
        val f = n.toFloat()
        return V(elements.map { it * f })
    }

    operator fun div(n: Number): V {
        val f = n.toFloat()
        return V(elements.map { it / f })
    }

    operator fun plus(v: V): V {
        return combine(this, v) { f1, f2 -> f1 + f2 }
    }

    operator fun minus(v: V): V {
        return combine(this, v) { f1, f2 -> f1 - f2 }
    }

    val length: Float
        get() {
            return sqrt(elements.sumOf { (it * it).toDouble() }).toFloat()
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

    companion object {


        private fun combine(v1: V, v2: V, f: (Float, Float) -> Float): V {
            val newElements = mutableListOf<Float>()

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
