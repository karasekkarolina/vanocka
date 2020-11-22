package cz.blackchameleon.vanocka.ui.products

import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

class ProductDetailFragment : BaseFragment(R.layout.fragment_product_detail) {

    override val viewModel: ProductDetailViewModel by viewModel()


}