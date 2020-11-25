package cz.blackchameleon.vanocka.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

abstract class BaseViewModel : ViewModel() {
    protected val _showError: MutableLiveData<String> = MutableLiveData()
    val showError: LiveData<String> = _showError
}