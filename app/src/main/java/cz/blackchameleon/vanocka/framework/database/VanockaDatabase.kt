package cz.blackchameleon.vanocka.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Room database object with 3 given entities [CartItemDb], [ProductDb], [ProfileDb]
 *
 * @author Karolina Klepackova on 23.11.2020.
 */
@Database(
    entities = [
        CartItemDb::class,
        ProductDb::class,
        ProfileDb::class
    ], exportSchema = false, version = 4
)
abstract class VanockaDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun productDao(): ProductDao

    abstract fun profileDao(): ProfileDao

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