package cz.blackchameleon.vanocka.ui.cart

import android.os.Bundle
import android.view.View
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import cz.blackchameleon.vanocka.ui.products.ProductAdapter
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_products.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class CartFragment : BaseFragment(R.layout.fragment_cart) {

    override val viewModel: CartViewModel by viewModel()

    private val cartAdapter: CartAdapter by lazy {
        CartAdapter(viewModel::onProductClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cart_list.adapter = cartAdapter

    }


}