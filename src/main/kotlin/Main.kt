package io.system

fun main() {
    val v1 = V(1, 2)
    val v2 = V(2, 3)
    val v3 = V(3, 4)

    val e1 = Node(v1)
    val e2 = Node(v2)
    val e3 = Node(v3)

    e1.next = e2
    e2.next = e3

    println(e1)
}
