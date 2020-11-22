package cz.blackchameleon.vanocka.ui.products

import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class ProductsFragment : BaseFragment(R.layout.fragment_products) {

    override val viewModel: ProductsViewModel by viewModel()


}