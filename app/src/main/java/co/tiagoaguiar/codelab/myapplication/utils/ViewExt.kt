package co.tiagoaguiar.codelab.myapplication.utils

import android.os.Build
import android.view.View
import android.view.WindowInsets
import androidx.annotation.RequiresApi

class ViewExt {

    /** ESCONDE O TECLADO */
    @RequiresApi(Build.VERSION_CODES.R)
    fun View.showKeyboard(view: View) {
        windowInsetsController?.show(WindowInsets.Type.ime())
        view.requestFocus()
    }

    /** EXIBE O TECLADO */
    @RequiresApi(Build.VERSION_CODES.R)
    fun View.hideKeyboard(view: View) {
        windowInsetsController?.hide(WindowInsets.Type.ime())
        view.clearFocus()
    }

}