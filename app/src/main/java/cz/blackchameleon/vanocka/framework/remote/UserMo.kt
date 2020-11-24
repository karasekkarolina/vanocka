package cz.blackchameleon.vanocka.framework.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Karolina Klepackova on 22.11.2020.
 */
@Parcelize
data class UserMo(
    val id: String,
    val name: String,
    val credits: Int
) : Parcelable