package com.example.room.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class Commons : AnkoLogger {

    companion object : AnkoLogger {


        fun loggingShowcase(message: String) {
            verbose(message)
            info(message)
            debug(message)
            warn(message)
            error(message)
            wtf(message) // what a terrrible failure
        }

        fun showActionTextSnackbar(view: View, message: String, context: Context) {
            view.snackbar("Hi there i m snackbar with action text!").setAction("Ok", View.OnClickListener {
                context.toast("Action button pressed")
            }).setActionTextColor(Color.parseColor("#ffff00")).setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE)
        }

    }
}