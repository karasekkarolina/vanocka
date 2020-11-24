package cz.blackchameleon.data

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
sealed class ErrorEntity {
    abstract val originalException: Throwable
    data class Network(override val originalException: Throwable) : ErrorEntity()
    data class NotFound(override val originalException: Throwable) : ErrorEntity()
    data class AccessDenied(override val originalException: Throwable) : ErrorEntity()
    data class ServiceUnavailable(override val originalException: Throwable) : ErrorEntity()
    data class Unknown(override val originalException: Throwable) : ErrorEntity()
}