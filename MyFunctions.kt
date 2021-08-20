package com.example.androidspiral

import android.os.Handler
import android.os.Looper
import android.view.View

object MyFunctions {
    val handler = Handler(Looper.getMainLooper())

    suspend fun animation(view: View, speedInMilliSeconds: Long) {
        var rotation = view.rotation
        val x = view.x
        val y = view.y
        view.y = view.y - 20

        handler.postDelayed(object : Runnable {
            override fun run() {
                when {
                    (rotation in 0f..10f) -> {
                        view.rotation = view.rotation + 1f
                        view.x = view.x + 3
                        rotation += 1
                        if (rotation == 9f) {
                            rotation = -10f
                            view.x = x
                            view.rotation = 0f
                            view.rotationY = 0f
                        }
                    }
                    (rotation in -10f..-1f) -> {
                        view.rotation = view.rotation - 1f
                        view.x = view.x - 3
                        rotation += 1
                        if (rotation == -1f) {
                            rotation = -0f
                            view.x = x
                            view.rotation = 0f
                            view.rotationY = 0f
                        }
                    }
                }
                handler.postDelayed(this, speedInMilliSeconds)
            }
        }, speedInMilliSeconds)
    }

    fun stopAnimation() {
        return handler.removeCallbacksAndMessages(null)
    }


}