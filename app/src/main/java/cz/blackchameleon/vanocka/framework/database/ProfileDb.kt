package cz.blackchameleon.vanocka.framework.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cz.blackchameleon.domain.Profile

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
@Entity(tableName = "users")
open class ProfileDb(
    @PrimaryKey
    open var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "credits")
    var credits: Int
) {
    fun toProfile(): Profile = Profile(
        id = this.id,
        name = this.name,
        credits = this.credits
    )
}