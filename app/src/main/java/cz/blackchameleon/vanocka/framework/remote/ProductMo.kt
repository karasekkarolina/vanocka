package cz.blackchameleon.vanocka.framework.remote

import android.os.Parcelable
import cz.blackchameleon.domain.Product
import kotlinx.android.parcel.Parcelize

/**
 * API object representation of product
 *
 * @author Karolina Klepackova on 22.11.2020.
 */
@Parcelize
class ProductMo(
    val id: String?,
    val name: String?,
    val title: String?,
    val image: String?,
    val price: Float?,
    val unit: String?
) : Parcelable {
    fun toProduct() = Product(
        id ?: "",
        name ?: "",
        title ?: "",
        image ?: "",
        price ?: 0f,
        unit ?: ""
    )
}