package cz.blackchameleon.vanocka.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.domain.Product
import cz.blackchameleon.domain.Profile
import cz.blackchameleon.usecases.profile.DeleteProfile
import cz.blackchameleon.usecases.profile.GetProfile
import cz.blackchameleon.usecases.profile.SaveProfile
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

    var profileId: Int? = null

    init {
        initData()
    }

    override fun initData() {
        startLoading()
        CoroutineScope(Dispatchers.IO).launch {
            profileId?.let { profileId ->
                getProfile(profileId).let {
                    when (it) {
                        is LocalResult.Success -> {
                            _profile.postValue(it.data)
                        }
                        is LocalResult.Error -> {
                            _showError.postValue(it.error)
                        }
                    }
                }
            } ?: LocalResult.Error<Product>("No product id found")
        }
        stopLoading()
    }

    fun saveProfile() {
        startLoading()
        CoroutineScope(Dispatchers.IO).launch {
            profile.value?.let {
                saveProfile(it)
            } ?: _showError.postValue("Profile not found")
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
}