package cz.blackchameleon.vanocka.framework.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
interface BaseDao<T> {
    @Insert
    suspend fun insert(obj: T)

    @Update
    suspend fun update(obj: T)

    @Delete
    suspend fun delete(obj: T)
}