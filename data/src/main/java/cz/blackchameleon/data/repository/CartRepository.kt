package cz.blackchameleon.data.repository

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.local.LocalCartSource
import cz.blackchameleon.data.remote.RemoteCartSource
import cz.blackchameleon.domain.CartItem
import kotlinx.coroutines.withContext
import java.lang.RuntimeException
import kotlin.coroutines.coroutineContext

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

class CartRepository(
    private val localCartSource: LocalCartSource,
    private val remoteCartSource: RemoteCartSource
) {
    suspend fun getCartItems(): LocalResult<List<CartItem>> =
        withContext(coroutineContext) {
            localCartSource.getCartItems()?.let {
                if (it.isNotEmpty()) {
                    return@withContext LocalResult.Success(it)
                }
            }

            try {
                val cartItems = remoteCartSource.fetchCartItems().blockingGet()
                return@withContext LocalResult.Success(cartItems)
            } catch (e: RuntimeException) {
                return@withContext LocalResult.Error<List<CartItem>>(e.message)
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