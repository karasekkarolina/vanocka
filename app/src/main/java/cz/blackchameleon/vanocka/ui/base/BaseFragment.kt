package cz.blackchameleon.vanocka.ui.base

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

abstract class BaseFragment(layout: Int) : Fragment(layout) {

    abstract val viewModel: BaseViewModel

    protected fun closeSoftKeyboard(view: View) {
        val inputMethodManager =
            requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}