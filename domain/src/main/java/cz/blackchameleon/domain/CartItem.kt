package cz.blackchameleon.domain

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

class CartItem(
    id: String,
    name: String,
    title: String,
    thumbnail_image: String,
    val amount: Int,
    price: Float,
    unit: String
) : Product(
    id = id,
    name = name,
    title = title,
    image = thumbnail_image,
    price = price,
    unit = unit
) {
    override fun equals(other: Any?): Boolean =
        super.equals(other) && amount == (other as CartItem).amount
}