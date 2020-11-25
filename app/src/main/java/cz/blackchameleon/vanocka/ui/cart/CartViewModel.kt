package cz.blackchameleon.vanocka.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.usecases.cart.GetCartItems
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Karolina Klepackova on 21.11.2020.
 */
class CartViewModel(
    private val getCartItems: GetCartItems
) : BaseViewModel() {
    private val _cartItems: MutableLiveData<List<CartItem>> = MutableLiveData()
    val cartItems: LiveData<List<CartItem>> = _cartItems

    init {
        initData()
    }

    override fun initData() {
        startLoading()
        CoroutineScope(Dispatchers.IO).launch {
            getCartItems().let {
                when (it) {
                    is LocalResult.Success -> {
                        _cartItems.postValue(it.data)
                    }
                    is LocalResult.Error -> {
                        _showError.postValue(R.string.cart_items_loading_failed)
                    }
                }
            }
        }
        stopLoading()
    }

    fun onMinusClicked(cartItem: CartItem) {
        if (cartItem.amount > 0) {
            val updatedList = cartItems.value?.let {
                val x = it.toMutableList()
                x[it.indexOfFirst { it.id == cartItem.id }] = CartItem(
                    id = cartItem.id,
                    name = cartItem.name,
                    title = cartItem.title,
                    image = cartItem.image,
                    amount = cartItem.amount.dec(),
                    price = cartItem.price,
                    unit = cartItem.unit
                )
                x
            } ?: emptyList()
            _cartItems.postValue(updatedList)
        }
    }

    fun onPlusClicked(cartItem: CartItem) {
        cartItem.amount.inc()
        _cartItems.value = cartItems.value
    }
}