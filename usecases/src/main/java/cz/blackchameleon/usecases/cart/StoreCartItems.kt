package cz.blackchameleon.usecases.cart

import cz.blackchameleon.data.repository.CartRepository
import cz.blackchameleon.domain.CartItem

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
class StoreCartItems(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(cartItems: List<CartItem>) {
        cartRepository.saveCartItems(cartItems)
    }
}