package cz.blackchameleon.vanocka.framework.remote

import android.os.Parcelable
import cz.blackchameleon.domain.CartItem
import kotlinx.android.parcel.Parcelize

/**
 * @author Karolina Klepackova on 22.11.2020.
 */
@Parcelize
class CartItemMo(
    override val id: String?,
    override val name: String?,
    override val title: String?,
    override val image: String?,
    val amount: Int?,
    override val price: Float?,
    override val unit: String?
) : Parcelable, ProductMo(
    id = id,
    name = name,
    title = title,
    image = image,
    price = price,
    unit = unit
) {
    fun toCartItem() = CartItem(
        id ?: "",
        name ?: "",
        title ?: "",
        image ?: "",
        amount ?: 0,
        price ?: 0f,
        unit ?: ""
    )
}