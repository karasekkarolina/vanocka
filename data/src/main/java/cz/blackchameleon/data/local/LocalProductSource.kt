package cz.blackchameleon.data.local

import cz.blackchameleon.domain.Product

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface LocalProductSource {
    suspend fun getProduct(): Product?

    suspend fun saveProduct(product: Product)

    suspend fun clean()
}