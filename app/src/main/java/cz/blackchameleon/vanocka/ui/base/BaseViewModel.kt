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

    private val _showEmptyState: MutableLiveData<Unit> = MutableLiveData()
    val showEmptyState: LiveData<Unit> = _showEmptyState

    abstract fun initData()

    fun onSwipeReload() {
        initData()
    }

    fun showEmptyState() {
        _showEmptyState.postValue(Unit)
    }
}