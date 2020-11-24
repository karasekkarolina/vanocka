package cz.blackchameleon.vanocka.framework

import cz.blackchameleon.data.ErrorEntity
import cz.blackchameleon.data.ErrorHandler
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
class ErrorHandlerImpl : ErrorHandler {
    override fun getError(throwable: Throwable): ErrorEntity {
        return when(throwable) {
            is IOException -> ErrorEntity.Network(throwable)
            is HttpException -> {
                when(throwable.code()) {
                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound(throwable)
                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied(throwable)
                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable(throwable)
                    else -> ErrorEntity.Unknown(throwable)
                }
            }
            else -> ErrorEntity.Unknown(throwable)
        }
    }
}