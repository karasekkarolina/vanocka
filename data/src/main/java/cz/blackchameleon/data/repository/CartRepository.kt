package cz.blackchameleon.data.repository

import cz.blackchameleon.data.Result
import cz.blackchameleon.data.local.LocalCartSource
import cz.blackchameleon.data.remote.RemoteCartSource
import cz.blackchameleon.domain.CartItem
import kotlinx.coroutines.withContext
import java.lang.RuntimeException
import kotlin.coroutines.coroutineContext

/**
 * Uses data sources implementations for providing cart items data for use cases
 *
 * @param localCartSource Local source [LocalCartSource]
 * @param remoteCartSource Remote source [RemoteCartSource]
 *
 * @author Karolina Klepackova on 23.11.2020.
 */

class CartRepository(
    private val localCartSource: LocalCartSource,
    private val remoteCartSource: RemoteCartSource
) {
    suspend fun getCartItems(): Result<List<CartItem>> =
        withContext(coroutineContext) {
            localCartSource.getCartItems()?.let {
                if (it.isNotEmpty()) {
                    return@withContext Result.Success(it)
                }
            }

            try {
                val cartItems = remoteCartSource.fetchCartItems().blockingGet()
                saveCartItems(cartItems)
                return@withContext Result.Success(cartItems)
            } catch (e: RuntimeException) {
                return@withContext Result.Error<List<CartItem>>(e.message)
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