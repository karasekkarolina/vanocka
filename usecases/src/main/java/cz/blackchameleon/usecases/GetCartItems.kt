package cz.blackchameleon.usecases

import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.repository.CartRepository
import cz.blackchameleon.domain.CartItem

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

class GetCartItems(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(): LocalResult<List<CartItem>> = cartRepository.getCartItems()
}