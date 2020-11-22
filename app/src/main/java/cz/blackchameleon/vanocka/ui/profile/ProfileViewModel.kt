package cz.blackchameleon.vanocka.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.vanocka.ui.base.BaseViewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class ProfileViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}