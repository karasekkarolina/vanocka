package cz.blackchameleon.vanocka.framework.remote

import android.os.Parcelable
import cz.blackchameleon.domain.Profile
import kotlinx.android.parcel.Parcelize

/**
 * @author Karolina Klepackova on 22.11.2020.
 */
@Parcelize
data class ProfileMo(
    val id: Int?,
    val name: String?,
    val credits: Int?
) : Parcelable {
    fun toProfile() = Profile(
        id ?: 0,
        name ?: "",
        credits ?: 0
    )
}