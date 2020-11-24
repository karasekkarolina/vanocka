package cz.blackchameleon.vanocka.extensions

import cz.blackchameleon.vanocka.framework.ErrorHandlerImpl
import cz.blackchameleon.data.RemoteResult

/**
 * @author Karolina Klepackova on 24.11.2020.
 */

suspend fun <T> withErrorHandling(block: suspend () -> T): RemoteResult<T> = try {
    RemoteResult.Success(block())
} catch (e: Throwable) {
    RemoteResult.Error(ErrorHandlerImpl().getError(e))
}
