package cz.blackchameleon.vanocka.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Database(
    entities = [
        CartItemDb::class,
        ProductDb::class
    ], exportSchema = false, version = 1
)
abstract class VanockaDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun productDao(): ProductDao

    companion object {
        private const val DB_NAME = "vanockaDb"
        var instance: VanockaDatabase? = null

        fun getInstance(context: Context): VanockaDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    VanockaDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}