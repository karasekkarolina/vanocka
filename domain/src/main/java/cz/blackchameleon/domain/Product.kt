package cz.blackchameleon.domain

/**
 * Representation of cart item entity
 *
 * @author Karolina Klepackova on 22.11.2020.
 */
open class Product(
    val id: String,
    val name: String,
    val title: String,
    val image: String,
    val price: Float,
    val unit: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        if (title != other.title) return false
        if (image != other.image) return false
        if (price != other.price) return false
        if (unit != other.unit) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + unit.hashCode()
        return result
    }
}