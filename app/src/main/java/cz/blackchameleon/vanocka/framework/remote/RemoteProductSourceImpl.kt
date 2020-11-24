package cz.blackchameleon.vanocka.framework.remote

import cz.blackchameleon.data.RemoteResult
import cz.blackchameleon.data.remote.RemoteProductSource
import cz.blackchameleon.domain.Product
import cz.blackchameleon.vanocka.extensions.withErrorHandling
import cz.blackchameleon.vanocka.framework.ProductApi


/**
 * @author Karolina Klepackova on 24.11.2020.
 */
class RemoteProductSourceImpl(private val productApi: ProductApi) : RemoteProductSource {
    override suspend fun fetchProduct(): RemoteResult<Product> =
        withErrorHandling { productApi.getProduct() }
}