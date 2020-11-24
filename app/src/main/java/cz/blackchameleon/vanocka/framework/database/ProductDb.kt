package cz.blackchameleon.vanocka.framework.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cz.blackchameleon.domain.Product

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Entity(tableName = "products")
open class ProductDb(
    @PrimaryKey
    open var id: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "thumbnail_image")
    var thumbnail_image: String,
    @ColumnInfo(name = "price")
    var price: Float,
    @ColumnInfo(name = "unit")
    var unit: String
) {
    fun toProduct(): Product = Product(
        id = this.id,
        name = this.name,
        title = this.title,
        image = this.thumbnail_image,
        price = this.price,
        unit = this.unit
    )
}