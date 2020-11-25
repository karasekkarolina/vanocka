package cz.blackchameleon.vanocka.ui.products

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.loading_overlay.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

class ProductDetailFragment : BaseFragment(R.layout.fragment_product_detail) {

    private val args: ProductDetailFragmentArgs by navArgs()
    override val viewModel: ProductDetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.productId = args.id
        initObservers()
    }

    private fun initObservers() {
        viewModel.product.observe(viewLifecycleOwner, {

        })

        viewModel.loading.observe(viewLifecycleOwner, { visible ->
            loading_overlay.isVisible = visible
        })

        viewModel.showError.observe(viewLifecycleOwner, {
            // TODO show error state
        })
    }
}