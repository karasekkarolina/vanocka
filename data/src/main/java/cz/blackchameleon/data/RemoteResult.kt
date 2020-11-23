package cz.blackchameleon.data

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

data class RemoteResult<T>(
    val data: T?,
    val error: String? = null
)