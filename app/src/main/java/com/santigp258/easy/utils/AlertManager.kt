package com.santigp258.easy.utils

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.santigp258.easy.R


class AlertManager(private val context: Context, private var view: View) {

    private fun showSnackBar(message: String, color: Int) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(context, color)).show()
    }

    fun success(message: String) {
        showSnackBar(message, R.color.green)
    }

    fun error(message: String) {
        showSnackBar(message, R.color.red)
    }

    fun info(message: String) {
        showSnackBar(message, R.color.blue)
    }
}