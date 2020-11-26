package cz.blackchameleon.data.repository

import cz.blackchameleon.data.Result
import cz.blackchameleon.data.local.LocalProfileSource
import cz.blackchameleon.data.remote.RemoteProfileSource
import cz.blackchameleon.domain.Profile
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

/**
 * Uses data sources implementations for providing profile data for use cases
 *
 * @param localProfileSource Local source [LocalProfileSource]
 * @param remoteProfileSource Remote source [RemoteProfileSource]
 *
 * @author Karolina Klepackova on 23.11.2020.
 */

class ProfileRepository(
    private val localProfileSource: LocalProfileSource,
    private val remoteProfileSource: RemoteProfileSource
) {
    suspend fun getProfile(id: Int): Result<Profile> =
        withContext(coroutineContext) {
            localProfileSource.getProfile(id)?.let {
                return@withContext Result.Success(it)
            }

            try {
                val profile = remoteProfileSource.fetchProfile().blockingGet()
                saveProfile(profile)
                return@withContext Result.Success(profile)
            } catch (e: RuntimeException) {
                return@withContext Result.Error<Profile>(e.message)
            }
        }

    suspend fun saveProfile(profile: Profile) {
        localProfileSource.saveProfile(profile)
    }

    suspend fun clean() = localProfileSource.clean()
}