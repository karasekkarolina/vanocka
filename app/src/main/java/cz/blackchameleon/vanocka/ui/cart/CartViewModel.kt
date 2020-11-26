package cz.blackchameleon.vanocka.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.Result
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.usecases.cart.GetCartItems
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model that provides information what to display in view represented by [CartFragment]
 * @see BaseViewModel
 *
 * @param getCartItems Use case [GetCartItems]
 *
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
        CoroutineScope(Dispatchers.IO).launch {
            getCartItems().let {
                when (it) {
                    is Result.Success -> {
                        _cartItems.postValue(it.data)
                    }
                    is Result.Error -> {
                        _showError.postValue(R.string.cart_items_loading_failed)
                    }
                }
            }
        }
    }

    fun onMinusClicked(cartItem: CartItem) {
        if (cartItem.amount > 0) {
            _cartItems.postValue(cartItems.value?.let { list ->
                val updatedList = list.toMutableList()
                updatedList[list.indexOfFirst { it.id == cartItem.id }] = CartItem(
                    id = cartItem.id,
                    name = cartItem.name,
                    title = cartItem.title,
                    image = cartItem.image,
                    amount = if (cartItem.amount.dec() < 0) 0f else cartItem.amount.dec(),
                    price = cartItem.price,
                    unit = cartItem.unit
                )
                updatedList
            } ?: emptyList())
        }
    }

    fun onPlusClicked(cartItem: CartItem) {
        _cartItems.postValue(cartItems.value?.let { list ->
            val updatedList = list.toMutableList()
            updatedList[list.indexOfFirst { it.id == cartItem.id }] = CartItem(
                id = cartItem.id,
                name = cartItem.name,
                title = cartItem.title,
                image = cartItem.image,
                amount = cartItem.amount.inc(),
                price = cartItem.price,
                unit = cartItem.unit
            )
            updatedList
        } ?: emptyList())
        _cartItems.value = cartItems.value
    }
}