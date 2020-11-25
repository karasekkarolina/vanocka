package cz.blackchameleon.vanocka.framework.remote

import cz.blackchameleon.data.remote.RemoteProfileSource
import cz.blackchameleon.domain.Profile
import cz.blackchameleon.vanocka.framework.ProfileApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
class RemoteProfileSourceImpl(private val profileApi: ProfileApi) : RemoteProfileSource {
    override suspend fun fetchProfile(): Single<Profile> =
        profileApi.getProfile()
            .map { it.toProfile() }
            .subscribeOn(Schedulers.io())
}