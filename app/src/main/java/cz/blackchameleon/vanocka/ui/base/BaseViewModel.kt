package cz.blackchameleon.vanocka.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

abstract class BaseViewModel : ViewModel() {
    protected val _showError: MutableLiveData<Int> = MutableLiveData()
    val showError: LiveData<Int> = _showError

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    abstract fun initData()

    fun onSwipeReload() {
        initData()
    }

    protected fun startLoading() {
        _loading.value = true
    }

    protected fun stopLoading() {
        _loading.value = false
    }
}