package cz.blackchameleon.vanocka.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.domain.Product
import cz.blackchameleon.usecases.products.GetProducts
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class ProductsViewModel(
    private val getProducts: GetProducts
) : BaseViewModel() {

    private val _products: MutableLiveData<List<Product>> = MutableLiveData()
    val products: LiveData<List<Product>> = _products

    init {
        initData()
    }

    override fun initData() {
        CoroutineScope(Dispatchers.IO).launch {
            getProducts().let {
                when (it) {
                    is LocalResult.Success -> {
                        _products.postValue(it.data)
                    }
                    is LocalResult.Error -> {
                        _showError.postValue(R.string.products_loading_failed)
                    }
                }
            }
        }
    }
}