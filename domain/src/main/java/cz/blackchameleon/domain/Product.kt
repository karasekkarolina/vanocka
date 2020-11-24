package cz.blackchameleon.domain

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

open class Product(
    val id: String,
    val name: String,
    val title: String,
    val image: String,
    val price: Float,
    val unit: String
)