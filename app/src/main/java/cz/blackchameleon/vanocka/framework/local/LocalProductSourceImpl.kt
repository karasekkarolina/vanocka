package cz.blackchameleon.vanocka.framework.local

import android.content.Context
import cz.blackchameleon.data.local.LocalProductSource
import cz.blackchameleon.domain.Product
import cz.blackchameleon.vanocka.framework.database.ProductDao
import cz.blackchameleon.vanocka.framework.database.ProductDb
import cz.blackchameleon.vanocka.framework.database.VanockaDatabase

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
class LocalProductSourceImpl(
    context: Context
) : LocalProductSource {
    private val database = VanockaDatabase.getInstance(context)
    private val productDao: ProductDao?

    init {
        productDao = database?.productDao()
    }

    override suspend fun getProduct(id: String): Product? = productDao?.getProduct(id)?.toProduct()

    override suspend fun getAllProducts(): List<Product>? =
        productDao?.getAllProducts()?.map {
            it.toProduct()
        }

    override suspend fun saveProduct(product: Product) {
        product.run {
            productDao?.insert(
                ProductDb(
                    id, name, title, thumbnail_image, price, unit
                )
            )
        }
    }

    override suspend fun clean() {
        productDao?.deleteAll()
    }
}