package com.santigp258.easy.utils

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.santigp258.easy.R


class AlertManager(private val context: Context, private var view: View) {
    fun success(message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(context, R.color.green))
            .show()
    }

    fun error(message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(context, R.color.red))
            .show()
    }

    fun info(message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(context, R.color.blue))
            .show()
    }
}