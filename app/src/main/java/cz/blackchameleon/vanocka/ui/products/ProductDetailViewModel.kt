package cz.blackchameleon.vanocka.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.domain.Product
import cz.blackchameleon.usecases.products.GetProduct
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Karolina Klepackova on 22.11.2020.
 */
class ProductDetailViewModel(
    private val getProduct: GetProduct
) : BaseViewModel() {

    private val _product: MutableLiveData<Product> = MutableLiveData()
    val product: LiveData<Product> = _product

    var productId: String? = null

    init {
        initData()
    }

    override fun initData() {
        CoroutineScope(Dispatchers.IO).launch {
            productId?.let { productId ->
                getProduct(productId).let {
                    when (it) {
                        is LocalResult.Success -> {
                            _product.postValue(it.data)
                        }
                        is LocalResult.Error -> {
                            _showError.postValue(R.string.product_loading_failed)
                        }
                    }
                }
            } ?: _showError.postValue(R.string.product_loading_failed)
        }
    }
}