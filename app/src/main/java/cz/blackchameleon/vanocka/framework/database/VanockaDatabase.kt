package cz.blackchameleon.vanocka.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.domain.Product

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Database(
    entities = [
        CartItem::class,
        Product::class
    ], exportSchema = false, version = 1
)
abstract class VanockaDatabase : RoomDatabase() {




    companion object {
        const val DB_NAME = "vanocka_db"
    }
}