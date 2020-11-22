package cz.blackchameleon.vanocka.ui.products

import android.os.Bundle
import android.view.View
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_products.*
import org.koin.androidx.viewmodel.ext.android.viewModel
/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class ProductsFragment : BaseFragment(R.layout.fragment_products) {

    override val viewModel: ProductsViewModel by viewModel()

    private val productAdapter: ProductAdapter by lazy {
        ProductAdapter(viewModel::onProductClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product_list.adapter = productAdapter


    }
}