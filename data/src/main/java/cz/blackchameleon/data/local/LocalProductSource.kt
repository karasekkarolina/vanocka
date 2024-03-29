package cz.blackchameleon.data.local

import cz.blackchameleon.domain.Product

/**
 * Interface specifying possible actions with locally stored data source of products in framework layer
 *
 * @author Karolina Klepackova on 23.11.2020.
 */

interface LocalProductSource {
    suspend fun getProduct(id: String): Product?

    suspend fun getAllProducts(): List<Product>?

    suspend fun saveProduct(product: Product)

    suspend fun clean()
}