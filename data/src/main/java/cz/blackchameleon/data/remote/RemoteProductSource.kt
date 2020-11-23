package cz.blackchameleon.data.remote

import cz.blackchameleon.data.RemoteResult
import cz.blackchameleon.domain.Product

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

interface RemoteProductSource {
    suspend fun fetchProduct() : RemoteResult<Product>
}