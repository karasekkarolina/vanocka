package cz.blackchameleon.data

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

sealed class RemoteResult<T> {
    data class Success<T>(val data: T) : RemoteResult<T>()
    data class Error<T>(val error: ErrorEntity) : RemoteResult<T>()
}