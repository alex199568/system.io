package io.system.desktop

import org.lwjgl.glfw.GLFW

class Window private constructor() {

    private var id: Long = 0L

    var title: String = ""
        set(value) {
            field = value
            GLFW.glfwSetWindowTitle(id, value)
        }

    constructor(width: Int, height: Int, title: String = "") : this() {
        GLFW.glfwDefaultWindowHints()

        id = GLFW.glfwCreateWindow(width, height, title, 0L, 0L)

        require(id != 0L)

        GLFW.glfwMakeContextCurrent(id)

        this.title = title
    }

    val shouldClose: Boolean
        get() {
            return GLFW.glfwWindowShouldClose(id)
        }

    fun swapBuffers() {
        GLFW.glfwSwapBuffers(id)
    }
}
