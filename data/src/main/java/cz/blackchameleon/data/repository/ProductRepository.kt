package cz.blackchameleon.data.repository

import cz.blackchameleon.data.Result
import cz.blackchameleon.data.local.LocalProductSource
import cz.blackchameleon.data.remote.RemoteProductSource
import cz.blackchameleon.domain.Product
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

/**
 * Uses data sources implementations for providing products data for use cases
 *
 * @param localProductSource Local source [LocalProductSource]
 * @param remoteProductSource Remote source [RemoteProductSource]
 *
 * @author Karolina Klepackova on 23.11.2020.
 */

class ProductRepository(
    private val localProductSource: LocalProductSource,
    private val remoteProductSource: RemoteProductSource
) {
    suspend fun getProduct(id: String): Result<Product> =
        withContext(coroutineContext) {
            localProductSource.getProduct(id)?.let {
                return@withContext Result.Success(it)
            }

            try {
                val product = remoteProductSource.fetchProduct().blockingGet()
                return@withContext Result.Success(product)
            } catch (e: RuntimeException) {
                return@withContext Result.Error<Product>(e.message)
            }
        }

    suspend fun getAllProducts(): Result<List<Product>> =
        withContext(coroutineContext) {
            localProductSource.getAllProducts()?.let {
                if (it.isNotEmpty()) {
                    return@withContext Result.Success(it)
                }
            }

            try {
                val products = remoteProductSource.fetchProducts().blockingGet()
                saveProducts(products)
                return@withContext Result.Success(products)
            } catch (e: RuntimeException) {
                return@withContext Result.Error<List<Product>>(e.message)
            }
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