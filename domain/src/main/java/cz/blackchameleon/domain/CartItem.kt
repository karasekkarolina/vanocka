package cz.blackchameleon.domain

/**
 * Representation of cart item entity
 *
 * @author Karolina Klepackova on 22.11.2020.
 */
class CartItem(
    id: String,
    name: String,
    title: String,
    image: String,
    var amount: Float,
    price: Float,
    unit: String
) : Product(
    id = id,
    name = name,
    title = title,
    image = image,
    price = price,
    unit = unit
) {
    override fun equals(other: Any?): Boolean =
        super.equals(other) && amount == (other as CartItem).amount

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + amount.hashCode()
        return result
    }
}