package cz.blackchameleon.vanocka.ui.cart

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cart.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class CartFragment : BaseFragment(R.layout.fragment_cart) {

    override val viewModel: CartViewModel by viewModel()

    private val cartAdapter: CartAdapter by lazy {
        CartAdapter(viewModel::onCartItemClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
        cart_list.adapter = cartAdapter
        cart_list.layoutManager = LinearLayoutManager(activity)
        cart_list.addItemDecoration(itemDecoration)

        viewModel.cartItems.observe(viewLifecycleOwner, Observer {
            cartAdapter.submitList(it)
        })
    }


}