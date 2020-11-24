package cz.blackchameleon.data.local

import cz.blackchameleon.domain.CartItem

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface LocalCartSource {
    suspend fun getCartItems(): List<CartItem>?

    suspend fun saveCartItem(cartItem: CartItem)

    suspend fun clean()
}