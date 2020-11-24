package cz.blackchameleon.vanocka.framework.local

import android.content.Context
import cz.blackchameleon.data.local.LocalCartSource
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.vanocka.framework.database.CartItemDao
import cz.blackchameleon.vanocka.framework.database.CartItemDb
import cz.blackchameleon.vanocka.framework.database.VanockaDatabase

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
class LocalCartSourceImpl(
    context: Context
) : LocalCartSource {
    private val database = VanockaDatabase.getInstance(context)
    private val cartItemDao: CartItemDao?

    init {
        cartItemDao = database?.cartItemDao()
    }

    override suspend fun getCartItems(): List<CartItem>? =
        cartItemDao?.getCartItems()?.map { it.toCartItem() }

    override suspend fun saveCartItem(cartItem: CartItem) {
        cartItem.run {
            cartItemDao?.insert(
                CartItemDb(
                    id, name, title, thumbnail_image, amount, price, unit
                )
            )
        }
    }

    override suspend fun clean() {
        cartItemDao?.deleteAll()
    }
}