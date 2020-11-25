package cz.blackchameleon.domain

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

data class Profile(
    val id: Int,
    val photo: String,
    val name: String,
    val credits: Int
)