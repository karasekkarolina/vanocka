package cz.blackchameleon.vanocka.framework.database

import androidx.room.Dao
import androidx.room.Query
import cz.blackchameleon.domain.CartItem

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Dao
interface CartItemDao: BaseDao<List<CartItem>> {
    @Query("Select * from cartItems")
    fun getCartItems(): List<CartItem>
}