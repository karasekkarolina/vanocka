package cz.blackchameleon.usecases.cart

import cz.blackchameleon.data.Result
import cz.blackchameleon.data.repository.CartRepository
import cz.blackchameleon.domain.CartItem

/**
 * Use case that returns cart items data
 * @param cartRepository Repository [CartRepository]
 *
 * @author Karolina Klepackova on 23.11.2020.
 */
class GetCartItems(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(): Result<List<CartItem>> = cartRepository.getCartItems()
}