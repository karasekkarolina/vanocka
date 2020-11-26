package cz.blackchameleon.data.remote

import cz.blackchameleon.domain.Product
import io.reactivex.rxjava3.core.Single

/**
 * Interface specifying which products data can be provided via API calls implemented in framework layer
 *
 * @author Karolina Klepackova on 23.11.2020.
 */

interface RemoteProductSource {
    suspend fun fetchProduct() : Single<Product>

    suspend fun fetchProducts() : Single<List<Product>>
}