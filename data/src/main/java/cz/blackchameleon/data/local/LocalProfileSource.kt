package cz.blackchameleon.data.local

import cz.blackchameleon.domain.Profile

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface LocalProfileSource {
    suspend fun getProfile(id: Int): Profile?

    suspend fun saveProfile(profile: Profile)

    suspend fun clean()
}