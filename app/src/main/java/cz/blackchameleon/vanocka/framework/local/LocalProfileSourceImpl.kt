package cz.blackchameleon.vanocka.framework.local

import android.content.Context
import cz.blackchameleon.data.local.LocalProfileSource
import cz.blackchameleon.domain.Product
import cz.blackchameleon.domain.Profile
import cz.blackchameleon.vanocka.framework.database.ProductDb
import cz.blackchameleon.vanocka.framework.database.ProfileDao
import cz.blackchameleon.vanocka.framework.database.ProfileDb
import cz.blackchameleon.vanocka.framework.database.VanockaDatabase

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
class LocalProfileSourceImpl(
    context: Context
) : LocalProfileSource {
    private val database = VanockaDatabase.getInstance(context)
    private val profileDao: ProfileDao?

    init {
        profileDao = database?.profileDao()
    }

    override suspend fun getProfile(id: Int): Profile? = profileDao?.getProfile(id)?.toProfile()

    override suspend fun saveProfile(profile: Profile) {
        profile.run {
            profileDao?.insert(
                ProfileDb(
                    id, name, credits
                )
            )
        }
    }

    override suspend fun clean() {
        profileDao?.deleteAll()
    }
}