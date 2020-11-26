package cz.blackchameleon.usecases.products

import cz.blackchameleon.data.Result
import cz.blackchameleon.data.repository.ProductRepository
import cz.blackchameleon.domain.Product

/**
 * Use case that returns products data
 * @param productRepository Repository [ProductRepository]
 *
 * @author Karolina Klepackova on 24.11.2020.
 */
class GetProducts(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): Result<List<Product>> = productRepository.getAllProducts()
}