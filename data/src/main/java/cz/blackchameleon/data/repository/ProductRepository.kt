package cz.blackchameleon.data.repository

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.local.LocalProductSource
import cz.blackchameleon.data.remote.RemoteProductSource
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.domain.Product

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

class ProductRepository(
    private val localProductSource: LocalProductSource,
    private val remoteProductSource: RemoteProductSource
) {
    suspend fun getCartItems(): LocalResult<Product> {
        localProductSource.getProduct()?.let {
            return LocalResult.Success(it)
        }

        val product = remoteProductSource.fetchProduct()
        return product.data?.let {
            LocalResult.Success(it)
        } ?: LocalResult.Error(product.error)
    }
}