package io.system.desktop

import io.system.Color
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11

object Gpu {

    var clearColor: Color = Color()
        set(value) {
            field = value
            GL11.glClearColor(
                value.r.toFloat(),
                value.g.toFloat(),
                value.b.toFloat(),
                value.a.toFloat()
            )
        }

    fun clear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT or GL11.GL_DEPTH_BUFFER_BIT)
    }

    fun setup() {
        GL.createCapabilities()
    }

    val version: String
        get() {
            return GL11.glGetString(GL11.GL_VERSION) ?: "Unknown GL version"
        }
}