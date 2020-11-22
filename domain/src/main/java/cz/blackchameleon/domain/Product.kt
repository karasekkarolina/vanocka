package cz.blackchameleon.domain

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

data class Product(
    val id: String,
    val name: String,
    val thumbnail_image: String,
    val amount: Int,
    val price: Float,
    val unit: String
)