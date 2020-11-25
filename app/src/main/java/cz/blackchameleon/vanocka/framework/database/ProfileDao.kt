package cz.blackchameleon.vanocka.framework.database

import androidx.room.Dao
import androidx.room.Query

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Dao
interface ProfileDao : BaseDao<ProfileDb> {
    @Query("SELECT * FROM users WHERE id=:id ")
    suspend fun getProfile(id: Int): ProfileDb

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}