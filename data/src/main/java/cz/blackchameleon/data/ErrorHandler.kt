package cz.blackchameleon.data

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}