package cz.blackchameleon.vanocka.framework

import android.content.Context
import cz.blackchameleon.data.local.LocalCartSource
import cz.blackchameleon.domain.CartItem

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
class CartItemsSource(
    context: Context
): LocalCartSource {
    override suspend fun getCartItems(): List<CartItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun saveCartItems(cartItems: List<CartItem>) {
        TODO("Not yet implemented")
    }
}