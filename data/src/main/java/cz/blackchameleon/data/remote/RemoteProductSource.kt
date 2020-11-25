package cz.blackchameleon.data.remote

import cz.blackchameleon.domain.Product
import io.reactivex.rxjava3.core.Single

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface RemoteProductSource {
    suspend fun fetchProduct() : Single<Product>

    suspend fun fetchProducts() : Single<List<Product>>
}