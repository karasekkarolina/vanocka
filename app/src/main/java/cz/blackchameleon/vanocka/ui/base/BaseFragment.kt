package cz.blackchameleon.vanocka.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import cz.blackchameleon.vanocka.R

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

abstract class BaseFragment(layout: Int) : Fragment(layout) {

    abstract val viewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showError.observe(viewLifecycleOwner, { error ->
            context?.let { context ->
                AlertDialog.Builder(context, R.style.Widget_Vanocka_AlertDialog)
                    .setTitle(R.string.error_occurred)
                    .setMessage(error)
                    .setPositiveButton(android.R.string.ok, null)
                    .show()
            }
        })
    }
}