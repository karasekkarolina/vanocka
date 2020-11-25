package cz.blackchameleon.data.repository

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.local.LocalProfileSource
import cz.blackchameleon.data.remote.RemoteProfileSource
import cz.blackchameleon.domain.Profile
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

class ProfileRepository(
    private val localProfileSource: LocalProfileSource,
    private val remoteProfileSource: RemoteProfileSource
) {
    suspend fun getProfile(id: Int): LocalResult<Profile> =
        withContext(coroutineContext) {
            localProfileSource.getProfile(id)?.let {
                return@withContext LocalResult.Success(it)
            }

            try {
                val profile = remoteProfileSource.fetchProfile().blockingGet()
                saveProfile(profile)
                return@withContext LocalResult.Success(profile)
            } catch (e: RuntimeException) {
                return@withContext LocalResult.Error<Profile>(e.message)
            }
        }

    suspend fun saveProfile(profile: Profile) {
        localProfileSource.saveProfile(profile)
    }

    suspend fun clean() = localProfileSource.clean()
}