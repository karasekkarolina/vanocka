package cz.blackchameleon.vanocka.framework.remote

import android.os.Parcelable
import cz.blackchameleon.domain.CartItem
import kotlinx.android.parcel.Parcelize

/**
 * API object representation of cart item
 *
 * @author Karolina Klepackova on 22.11.2020.
 */
@Parcelize
class CartItemMo(
    val id: String?,
    val name: String?,
    val title: String?,
    val image: String?,
    val amount: Float?,
    val price: Float?,
    val unit: String?
) : Parcelable {
    /**
     * Conversion of API object into Cart item
     */
    fun toCartItem() = CartItem(
        id ?: "",
        name ?: "",
        title ?: "",
        image ?: "",
        amount ?: 0f,
        price ?: 0f,
        unit ?: ""
    )
}