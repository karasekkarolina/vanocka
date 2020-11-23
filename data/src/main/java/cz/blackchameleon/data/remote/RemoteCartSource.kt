package cz.blackchameleon.data.remote

import cz.blackchameleon.data.RemoteResult
import cz.blackchameleon.domain.CartItem

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface RemoteCartSource {
    suspend fun fetchCartItems() : RemoteResult<List<CartItem>>
}