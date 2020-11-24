package cz.blackchameleon.data.remote

import cz.blackchameleon.domain.CartItem
import io.reactivex.rxjava3.core.Single

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface RemoteCartSource {
    suspend fun fetchCartItems() : Single<List<CartItem>>
}