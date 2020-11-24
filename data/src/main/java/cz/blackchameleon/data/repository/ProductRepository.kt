package cz.blackchameleon.data.repository

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.RemoteResult
import cz.blackchameleon.data.local.LocalProductSource
import cz.blackchameleon.data.remote.RemoteProductSource
import cz.blackchameleon.domain.Product

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

class ProductRepository(
    private val localProductSource: LocalProductSource,
    private val remoteProductSource: RemoteProductSource
) {
    suspend fun getProduct(id: String): LocalResult<Product> {
        localProductSource.getProduct(id)?.let {
            return LocalResult.Success(it)
        }

        return when (val result = remoteProductSource.fetchProduct()) {
            is RemoteResult.Success -> {
                LocalResult.Success(result.data)
            }
            is RemoteResult.Error -> {
                LocalResult.Error(result.error.originalException.message)
            }
        }
    }

    suspend fun getAllProducts(): LocalResult<List<Product>> {
        return localProductSource.getAllProducts()?.let {
            LocalResult.Success(it)
        } ?: LocalResult.Error("No project items found")
    }

    suspend fun saveProducts(products: List<Product>) {
        products.forEach {
            saveProduct(it)
        }
    }

    suspend fun saveProduct(product: Product) {
        localProductSource.saveProduct(product)
    }

    suspend fun clean() = localProductSource.clean()
}