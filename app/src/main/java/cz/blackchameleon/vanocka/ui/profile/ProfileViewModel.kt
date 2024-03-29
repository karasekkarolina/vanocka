package cz.blackchameleon.vanocka.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.Result
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
 * View model that provides information what to display in view represented by [ProfileFragment]
 * @see BaseViewModel
 *
 * @param getProfile Use case [GetProfile]
 * @param saveProfile Use case [SaveProfile]
 * @param deleteProfile Use case [DeleteProfile]
 *
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
        CoroutineScope(Dispatchers.IO).launch {
            getProfile(TESTING_PROFILE_ID).let {
                when (it) {
                    is Result.Success -> {
                        _profile.postValue(it.data)
                    }
                    is Result.Error -> {
                        _showError.postValue(R.string.profile_loading_failed)
                    }
                }
            }
        }
    }

    fun saveProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            profile.value?.let {
                saveProfile(it)
            } ?: _showError.postValue(R.string.profile_loading_failed)
        }
    }

    fun deleteProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            deleteProfile.invoke()
        }
    }

    private companion object {
        private const val TESTING_PROFILE_ID = 456
    }
}