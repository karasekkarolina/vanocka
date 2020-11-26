package cz.blackchameleon.vanocka.framework

import cz.blackchameleon.vanocka.framework.remote.CartItemMo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Interface for cart items API calls
 *
 * @author Karolina Klepackova on 23.11.2020.
 */
interface CartApi {

    // Returns cart items list
    @GET("/cart")
    fun getCartItems(): Single<List<CartItemMo>>
}