package cz.blackchameleon.vanocka.framework.remote

import android.os.Parcelable
import cz.blackchameleon.domain.Product
import kotlinx.android.parcel.Parcelize

/**
 * @author Karolina Klepackova on 22.11.2020.
 */
@Parcelize
open class ProductMo(
    open val id: String?,
    open val name: String?,
    open val title: String?,
    open val image: String?,
    open val price: Float?,
    open val unit: String?
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