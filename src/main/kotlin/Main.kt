package io.system

fun main() {
    val v1 = V(1, 2)
    val v2 = V(2, 3)
    val v3 = V(3, 4)

    val queue = Queue<V>()
    println(queue)
    queue.enqueue(v1)
    println(queue)
    queue.enqueue(v2)
    println(queue)
    queue.enqueue(v3)
    println(queue)

    while (queue.isNotEmpty) {
        println(queue.dequeue())
        println(queue)
    }
}
