package cz.blackchameleon.data.local

import cz.blackchameleon.domain.CartItem

/**
 * Interface specifying possible actions with locally stored data source of cart items in framework layer
 *
 * @author Karolina Klepackova on 23.11.2020.
 */

interface LocalCartSource {
    suspend fun getCartItems(): List<CartItem>?

    suspend fun saveCartItem(cartItem: CartItem)

    suspend fun clean()
}