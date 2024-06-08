package com.santigp258.easy.utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.santigp258.easy.R


class AlertManager(private val context: Context, private var view: View) {

    private fun showSnackBar(message: String, color: Int) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)

        val snackbarView = snackbar.view
        val params = snackbarView.layoutParams as ViewGroup.MarginLayoutParams

        params.setMargins(params.leftMargin, 0, params.rightMargin, params.bottomMargin)
        snackbarView.layoutParams = params

        snackbarView.viewTreeObserver.addOnPreDrawListener(object :
            ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                snackbarView.viewTreeObserver.removeOnPreDrawListener(this)
                snackbarView.translationY = 0f
                return true
            }
        })

        snackbar.setBackgroundTint(ContextCompat.getColor(context, color)).show()
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