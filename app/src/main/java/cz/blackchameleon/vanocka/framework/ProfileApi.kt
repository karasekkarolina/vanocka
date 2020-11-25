package cz.blackchameleon.vanocka.framework

import cz.blackchameleon.vanocka.framework.remote.ProfileMo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * @author Karolina Klepackova on 25.11.2020.
 */
interface ProfileApi {

    // Returns user info
    @GET("/me")
    fun getProfile(): Single<ProfileMo>
}