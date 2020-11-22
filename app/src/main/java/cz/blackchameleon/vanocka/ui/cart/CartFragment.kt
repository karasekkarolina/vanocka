package cz.blackchameleon.vanocka.ui.cart

import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class CartFragment : BaseFragment(R.layout.fragment_cart) {

    override val viewModel: CartViewModel by viewModel()


}