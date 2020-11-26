package cz.blackchameleon.vanocka.framework

import cz.blackchameleon.vanocka.framework.remote.ProductMo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Interface for products API calls
 *
 * @author Karolina Klepackova on 23.11.2020.
 */
interface ProductApi {

    // Returns product by id
    @GET("/products/{id}")
    fun getProduct(): Single<ProductMo>

    // Returns all products
    @GET("/products")
    fun getProducts(): Single<List<ProductMo>>
}