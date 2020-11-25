package cz.blackchameleon.vanocka.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.domain.Profile
import cz.blackchameleon.usecases.profile.DeleteProfile
import cz.blackchameleon.usecases.profile.GetProfile
import cz.blackchameleon.usecases.profile.SaveProfile
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Karolina Klepackova on 21.11.2020.
 */
class ProfileViewModel(
    private val getProfile: GetProfile,
    private val saveProfile: SaveProfile,
    private val deleteProfile: DeleteProfile
) : BaseViewModel() {

    private val _profile: MutableLiveData<Profile> = MutableLiveData()
    val profile: LiveData<Profile> = _profile

    init {
        initData()
    }

    override fun initData() {
        startLoading()
        CoroutineScope(Dispatchers.IO).launch {
            getProfile(TESTING_PROFILE_ID).let {
                when (it) {
                    is LocalResult.Success -> {
                        _profile.postValue(it.data)
                    }
                    is LocalResult.Error -> {
                        _showError.postValue(R.string.profile_loading_failed)
                    }
                }
            }
        }
        stopLoading()
    }

    fun saveProfile() {
        startLoading()
        CoroutineScope(Dispatchers.IO).launch {
            profile.value?.let {
                saveProfile(it)
            } ?: _showError.postValue(R.string.profile_loading_failed)
        }
        stopLoading()
    }

    fun deleteProfile() {
        startLoading()
        CoroutineScope(Dispatchers.IO).launch {
            deleteProfile.invoke()
        }
        stopLoading()
    }

    private companion object {
        private const val TESTING_PROFILE_ID = 456
    }
}