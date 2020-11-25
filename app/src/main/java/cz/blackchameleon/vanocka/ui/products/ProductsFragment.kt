package cz.blackchameleon.vanocka.ui.products

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_products.*
import kotlinx.android.synthetic.main.loading_overlay.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */
class ProductsFragment : BaseFragment(R.layout.fragment_products) {

    override val viewModel: ProductsViewModel by viewModel()

    private val productAdapter: ProductAdapter by lazy {
        ProductAdapter {
            findNavController().navigate(ProductsFragmentDirections.actionProductDetailFragment(it.id))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        product_list.adapter = productAdapter
        product_list.layoutManager = LinearLayoutManager(activity)
        product_list.addItemDecoration(itemDecoration)

        swipe_layout.setOnRefreshListener { viewModel.onSwipeReload() }
        initObservers()
    }

    private fun initObservers() {
        viewModel.products.observe(viewLifecycleOwner, {
            productAdapter.submitList(it)
        })

        viewModel.loading.observe(viewLifecycleOwner, { visible ->
            loading_overlay.isVisible = visible
            swipe_layout.isRefreshing = visible
        })
    }
}