package cz.blackchameleon.vanocka.framework.remote

import cz.blackchameleon.data.remote.RemoteProductSource
import cz.blackchameleon.domain.Product
import cz.blackchameleon.vanocka.framework.ProductApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Remote source implementation for getting products from API
 * Implementation of [RemoteProductSource]
 *
 * @author Karolina Klepackova on 24.11.2020.
 */
class RemoteProductSourceImpl(private val productApi: ProductApi) : RemoteProductSource {
    override suspend fun fetchProduct(): Single<Product> =
        productApi.getProduct()
            .map { it.toProduct() }
            .subscribeOn(Schedulers.io())

    override suspend fun fetchProducts(): Single<List<Product>> =
        productApi.getProducts()
            .map { list ->
                list.map {
                    it.toProduct()
                }
            }
            .subscribeOn(Schedulers.io())
}