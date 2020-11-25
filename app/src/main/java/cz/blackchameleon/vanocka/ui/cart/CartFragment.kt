package cz.blackchameleon.vanocka.ui.cart

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.loading_overlay.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */
class CartFragment : BaseFragment(R.layout.fragment_cart) {

    override val viewModel: CartViewModel by viewModel()

    private val cartAdapter: CartAdapter by lazy {
        CartAdapter(viewModel::onMinusClicked, viewModel::onPlusClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        cart_list.adapter = cartAdapter
        cart_list.layoutManager = LinearLayoutManager(activity)
        cart_list.addItemDecoration(itemDecoration)

        swipe_layout.setOnRefreshListener { viewModel.onSwipeReload() }
        initObservers()
    }

    private fun initObservers() {
        viewModel.cartItems.observe(viewLifecycleOwner, {
            cartAdapter.submitList(it)
        })

        viewModel.loading.observe(viewLifecycleOwner, { visible ->
            loading_overlay.isVisible = visible
            swipe_layout.isRefreshing = visible
        })
    }
}