package cz.blackchameleon.data.local

import cz.blackchameleon.domain.Profile

/**
 * Interface specifying possible actions with locally stored data source of profiles in framework layer
 *
 * @author Karolina Klepackova on 23.11.2020.
 */

interface LocalProfileSource {
    suspend fun getProfile(id: Int): Profile?

    suspend fun saveProfile(profile: Profile)

    suspend fun clean()
}