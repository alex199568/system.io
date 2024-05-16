package io.system

import kotlin.math.sqrt

data class V4(
    val x: Float,
    val y: Float,
    val z: Float,
    val w: Float
) {

    constructor(
        x: Number = 0,
        y: Number = 0,
        z: Number = 0,
        w: Number = 0
    ) : this(
        x.toFloat(),
        y.toFloat(),
        z.toFloat(),
        w.toFloat()
    )

    operator fun plus(v: V4): V4 {
        return V4(
            x + v.x,
            y + v.y,
            z + v.z,
            w + v.w
        )
    }

    operator fun minus(v: V4): V4 {
        return V4(
            x - v.x,
            y - v.y,
            z - v.z,
            w - v.w
        )
    }

    operator fun times(n: Number): V4 {
        val f = n.toFloat()
        return V4(
            x * f,
            y * f,
            z * f,
            w * f
        )
    }

    operator fun div(n: Number): V4 {
        val f = n.toFloat()
        return V4(
            x / f,
            y / f,
            z / f,
            w / f
        )
    }

    operator fun unaryMinus(): V4 {
        return V4(-x, -y, -z, -w)
    }

    val length: Float
        get() {
            return sqrt(x * x + y * y + z * z + w * w)
        }

    val unit: V4
        get() {
            return this / length
        }
}
