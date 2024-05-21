package io.system.desktop

import io.system.Color
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWErrorCallback

object DesktopMain {

    fun setup() {
        GLFWErrorCallback.createPrint(System.err).set()

        require(GLFW.glfwInit())
    }

    fun pollEvents() {
        GLFW.glfwPollEvents()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        setup()

        val window = Window(300, 300, "Desktop")

        Gpu.setup()

        window.title = "Desktop ${Gpu.version}"

        Gpu.clearColor = Color(1.0, 0.2, 0.3)

        while (!window.shouldClose) {
            Gpu.clear()

            window.swapBuffers()

            pollEvents()
        }
    }
}
