package cz.blackchameleon.vanocka.framework.remote

import cz.blackchameleon.data.RemoteResult
import cz.blackchameleon.data.remote.RemoteCartSource
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.vanocka.extensions.withErrorHandling
import cz.blackchameleon.vanocka.framework.CartApi

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
class RemoteCartSourceImpl(private val cartApi: CartApi) : RemoteCartSource {
    override suspend fun fetchCartItems(): RemoteResult<List<CartItem>> =
        withErrorHandling { cartApi.getCartItems() }

}