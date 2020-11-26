package cz.blackchameleon.vanocka.framework.remote

import cz.blackchameleon.data.remote.RemoteCartSource
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.vanocka.framework.CartApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Remote source implementation for getting cart items from API
 * Implementation of [RemoteCartSource]
 *
 * @author Karolina Klepackova on 24.11.2020.
 */
class RemoteCartSourceImpl(private val cartApi: CartApi) : RemoteCartSource {
    override suspend fun fetchCartItems(): Single<List<CartItem>> =
        cartApi.getCartItems()
            .map { list ->
                list.map {
                    it.toCartItem()
                }
            }
            .subscribeOn(Schedulers.io())
}