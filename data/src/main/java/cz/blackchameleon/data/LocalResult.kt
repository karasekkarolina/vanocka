package cz.blackchameleon.data

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

sealed class LocalResult <T>{
    abstract val isSuccess: Boolean

    data class Success <T> (
        val data: T
    ): LocalResult<T>() {
        override val isSuccess: Boolean
            get() = true
    }
    data class Error <T>(
        val error: String? = null
    ): LocalResult<T>() {
        override val isSuccess: Boolean
            get() = false
    }
}