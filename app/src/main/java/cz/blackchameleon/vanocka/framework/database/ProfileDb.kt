package cz.blackchameleon.vanocka.framework.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cz.blackchameleon.domain.Profile

/**
 * Profile entity representation in DB
 * Defines DB table
 *
 * @author Karolina Klepackova on 23.11.2020.
 */
@Entity(tableName = "users")
open class ProfileDb(
    @PrimaryKey
    open var id: Int,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "credits")
    var credits: Int
) {
    /**
     * Conversion of DB object into [Profile]
     */
    fun toProfile(): Profile = Profile(
        id = this.id,
        photo = this.photo,
        name = this.name,
        credits = this.credits
    )
}