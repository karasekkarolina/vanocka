package cz.blackchameleon.vanocka.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.domain.Product
import cz.blackchameleon.usecases.cart.GetProduct
import cz.blackchameleon.vanocka.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class ProductsViewModel(
    private val getProduct: GetProduct
) : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _product: MutableLiveData<Product> = MutableLiveData()
    val product: LiveData<Product> = _product

    fun onProductClicked(product: Product) {

    }

    init {
        initProduct()
    }


    private fun initProduct() {
        CoroutineScope(Dispatchers.IO).launch {
            getProduct().let {
                when (it) {
                    is LocalResult.Success -> {
                        _product.postValue(it.data)
                    }
                    is LocalResult.Error -> {

                    }
                }
            }
        }
    }
}