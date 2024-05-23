package io.system

import io.system.num.Rational

class Matrix(
    private val n: Int,
    private val m: Int
) {

    private val elements = Array(n) {
        Array(m) {
            Rational(0)
        }
    }

    constructor(
        vararg rows: Array<Rational>
    ) : this(rows.size, rows.maxOf { it.size }) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (j < rows[i].size) {
                    this[i, j] = rows[i][j]
                }
            }
        }
    }

    constructor(
        vararg rows: Array<Int>
    ) : this(rows.size, rows.maxOf { it.size }) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (j < rows[i].size) {
                    this[i, j] = Rational(rows[i][j])
                }
            }
        }
    }

    operator fun get(i: Int, j: Int): Rational {
        return elements[i][j]
    }

    operator fun set(i: Int, j: Int, r: Rational) {
        elements[i][j] = r
    }

    override fun toString(): String {
        val sb = StringBuilder()

        val maxLength = elements.flatten().map { it.toString().length }.max()

        for (i in 0 until n) {
            sb.append("| ")
            for (j in 0 until m) {
                val r = elements[i][j]
                if (r >= 0) {
                    sb.append(" ")
                }
                val rString = r.toString()
                sb.append(rString)
                val spaces = maxLength - rString.length
                sb.append(" ".repeat(spaces))
                if (r < 0) {
                    sb.append(" ")
                }
            }
            sb.append(" |\n")
        }

        return sb.toString()
    }

    operator fun plus(other: Matrix): Matrix {
        val result = Matrix(n, m)

        for (i in 0 until n) {
            for (j in 0 until m) {
                result[i, j] = this[i, j] + other[i, j]
            }
        }

        return result
    }

    operator fun minus(other: Matrix): Matrix {
        val result = Matrix(n, m)

        for (i in 0 until n) {
            for (j in 0 until m) {
                result[i, j] = this[i, j] - other[i, j]
            }
        }

        return result
    }

    operator fun times(r: Rational): Matrix {
        val result = Matrix(n, m)

        for (i in 0 until n) {
            for (j in 0 until m) {
                result[i, j] = this[i, j] * r
            }
        }

        return result
    }

    operator fun times(i: Int): Matrix {
        return this * Rational(i)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val m1 = Matrix(
                arrayOf(1, 2),
                arrayOf(4, 5)
            )
            val result = m1 * 3
            println(result)
        }
    }
}
