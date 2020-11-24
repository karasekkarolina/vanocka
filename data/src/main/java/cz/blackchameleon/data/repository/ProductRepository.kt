package cz.blackchameleon.data.repository

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.RemoteResult
import cz.blackchameleon.data.local.LocalProductSource
import cz.blackchameleon.data.remote.RemoteProductSource
import cz.blackchameleon.domain.Product
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.withContext
import java.lang.Error
import kotlin.coroutines.coroutineContext

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

class ProductRepository(
    private val localProductSource: LocalProductSource,
    private val remoteProductSource: RemoteProductSource
) {
    suspend fun getProduct(id: String): LocalResult<Product> =
        withContext(coroutineContext) {
            localProductSource.getProduct(id)?.let {
                return@withContext LocalResult.Success(it)
            }

            try {
                val product = remoteProductSource.fetchProduct().blockingGet()
                return@withContext LocalResult.Success(product)
            } catch (e: RuntimeException) {
                return@withContext LocalResult.Error<Product>(e.message)
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