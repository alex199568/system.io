package io.system

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
        val newElements = mutableListOf<Float>()

        val long: V
        val short: V

        if (elements.size > v.elements.size) {
            long = this
            short = v
        } else {
            long = v
            short = this
        }

        long.elements.forEachIndexed { index, fl ->
            newElements += fl + short[index]
        }

        return V(newElements)
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
}
