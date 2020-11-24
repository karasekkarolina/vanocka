package cz.blackchameleon.data.repository

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.RemoteResult
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

        return when (val result = remoteCartSource.fetchCartItems()) {
            is RemoteResult.Success -> {
                LocalResult.Success(result.data)
            }
            is RemoteResult.Error -> {
                LocalResult.Error(result.error.originalException.message)
            }
        }
    }

    suspend fun saveCartItems(cartItems: List<CartItem>) {
        cartItems.forEach {
            saveCartItem(it)
        }
    }

    suspend fun saveCartItem(cartItem: CartItem) {
        localCartSource.saveCartItem(cartItem)
    }

    suspend fun clean() = localCartSource.clean()
}