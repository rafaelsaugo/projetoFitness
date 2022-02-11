package co.tiagoaguiar.codelab.myapplication.utils

import android.os.Build
import android.view.View
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

class FragmentExt {
    /** ESCONDE TECLADO */
fun Fragment.hideKeyboard(view: View? = activity?.window?.decorView?.rootView){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){

    }else {

    }
}


}

