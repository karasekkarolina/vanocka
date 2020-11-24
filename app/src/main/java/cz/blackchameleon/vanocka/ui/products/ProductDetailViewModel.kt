package cz.blackchameleon.vanocka.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.usecases.cart.GetCartItems
import cz.blackchameleon.usecases.cart.GetProduct
import cz.blackchameleon.vanocka.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Karolina Klepackova on 22.11.2020.
 */
class ProductDetailViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

}