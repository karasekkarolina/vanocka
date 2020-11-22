package cz.blackchameleon.vanocka.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.vanocka.ui.base.BaseViewModel

/**
 * @author Karolina Klepackova on 22.11.2020.
 */
class ProductDetailViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}