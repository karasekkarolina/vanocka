package cz.blackchameleon.vanocka.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.usecases.cart.GetCartItems
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
                        _showError.postValue(it.error)
                    }
                }
                stopLoading()
            }
        }
    }
}