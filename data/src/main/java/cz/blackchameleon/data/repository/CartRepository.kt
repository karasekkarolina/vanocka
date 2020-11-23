package cz.blackchameleon.data.repository

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.local.LocalCartSource
import cz.blackchameleon.data.remote.RemoteCartSource
import cz.blackchameleon.domain.CartItem

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

class CartRepository(
    private val localCartSource: LocalCartSource,
    private val remoteCartSource: RemoteCartSource
) {
    suspend fun getCartItems(): LocalResult<List<CartItem>> {
        localCartSource.getCartItems()?.let {
            return LocalResult.Success(it)
        }

        val cartItems = remoteCartSource.fetchCartItems()
        return cartItems.data?.let {
          LocalResult.Success(it)
        } ?: LocalResult.Error(cartItems.error)
    }

    suspend fun saveCartItems(cartItems: List<CartItem>) {
        localCartSource.saveCartItems(cartItems)
    }
}