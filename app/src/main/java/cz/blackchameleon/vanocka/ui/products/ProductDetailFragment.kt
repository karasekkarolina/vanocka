package cz.blackchameleon.vanocka.ui.products

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.extensions.setImage
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_product_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

class ProductDetailFragment : BaseFragment(R.layout.fragment_product_detail) {

    private val args: ProductDetailFragmentArgs by navArgs()
    override val viewModel: ProductDetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        overlay.isVisible = true
        viewModel.productId = args.id
        initObservers()
    }

    private fun initObservers() {
        viewModel.product.observe(viewLifecycleOwner, { product ->
            product_image.setImage(product.image)
            product_name.text = product.name
            product_title.text = product.title
            product_price.text = "${product.price} CZK"
            product_unit.text = resources.getString(R.string.product_unit, product.unit)
            overlay.isVisible = false
        })

        viewModel.showEmptyState.observe(viewLifecycleOwner, {
            main_content.isVisible = false
            no_data_text.isVisible = true
            overlay.isVisible = false
        })
    }
}