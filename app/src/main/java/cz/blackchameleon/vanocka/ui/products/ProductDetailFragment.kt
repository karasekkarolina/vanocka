package cz.blackchameleon.vanocka.ui.products

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

class ProductDetailFragment : BaseFragment(R.layout.fragment_product_detail) {

    override val viewModel: ProductDetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.productId = ""
        initObservers()
    }

    private fun initObservers() {
        viewModel.showError.observe(viewLifecycleOwner, Observer {
            // TODO show error state
        })
    }

}