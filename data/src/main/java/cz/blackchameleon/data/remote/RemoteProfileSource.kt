package cz.blackchameleon.data.remote

import cz.blackchameleon.domain.Profile
import io.reactivex.rxjava3.core.Single

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface RemoteProfileSource {
    suspend fun fetchProfile() : Single<Profile>
}