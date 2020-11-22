package cz.blackchameleon.vanocka.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.blackchameleon.domain.Product
import cz.blackchameleon.vanocka.ui.base.BaseViewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class CartViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun onProductClicked(product: Product) {

    }

}