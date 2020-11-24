package cz.blackchameleon.vanocka.framework.database

import androidx.room.Dao
import androidx.room.Query

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Dao
interface ProductDao : BaseDao<ProductDb> {

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<ProductDb>

    @Query("SELECT * FROM products WHERE id=:id ")
    suspend fun getProduct(id: String): ProductDb

    @Query("DELETE FROM products")
    suspend fun deleteAll()
}