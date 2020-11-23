package cz.blackchameleon.vanocka.framework.database

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

@Entity(tableName = "cartItems")
class CartItemDb(
    id: String,
    name: String,
    title: String,
    thumbnail_image: String,
    @ColumnInfo(name = "amount")
    val amount: Int,
    price: Float,
    unit: String
): ProductDb(
    id = id,
    name = name,
    title = title,
    thumbnail_image = thumbnail_image,
    price = price,
    unit = unit
)