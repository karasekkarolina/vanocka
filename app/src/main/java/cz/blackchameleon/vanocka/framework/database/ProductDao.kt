package cz.blackchameleon.vanocka.framework.database

import androidx.room.Dao
import androidx.room.Query
import cz.blackchameleon.domain.Product

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Dao
interface ProductDao : BaseDao<Product> {
    @Query("Select * from products")
    fun getProducts(): Product
}