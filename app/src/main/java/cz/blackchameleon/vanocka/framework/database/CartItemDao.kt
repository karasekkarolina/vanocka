package cz.blackchameleon.vanocka.framework.database

import androidx.room.Dao
import androidx.room.Query

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Dao
interface CartItemDao : BaseDao<CartItemDb> {
    @Query("SELECT * FROM cartItems")
    suspend fun getCartItems(): List<CartItemDb>

    @Query("DELETE FROM cartItems")
    suspend fun deleteAll()
}