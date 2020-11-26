package cz.blackchameleon.vanocka.ui.cart

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cart.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment that handles UI for cart items list
 * @see BaseFragment
 *
 * @author Karolina Klepackova on 21.11.2020.
 */
class CartFragment : BaseFragment(R.layout.fragment_cart) {

    override val viewModel: CartViewModel by viewModel()

    private val cartAdapter: CartAdapter by lazy {
        CartAdapter(viewModel::onMinusClicked, viewModel::onPlusClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        overlay.isVisible = true

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
            overlay.isVisible = false
            swipe_layout.isRefreshing = false
        })
        viewModel.showEmptyState.observe(viewLifecycleOwner, {
            no_data_text.isVisible = true
            swipe_layout.isVisible = false
            overlay.isVisible = false
        })
    }
}