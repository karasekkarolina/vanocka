package cz.blackchameleon.vanocka.framework

import cz.blackchameleon.domain.CartItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
interface CartApi {

    // Returns cart items list
    @GET("/cart")
    fun getCartItems(): Observable<List<CartItem>>
}