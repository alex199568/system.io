package io.system

class Node<T>(
    val item: T,
    var next: Node<T>? = null
) {

    override fun toString(): String {
        return "|$item| -> $next"
    }
}
