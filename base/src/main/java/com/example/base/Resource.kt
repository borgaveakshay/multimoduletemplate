package com.example.base

data class Resource<T> private constructor(
    val data: T?,
    val error: String?,
    val exception: Exception?
) {

    companion object {
        fun <T> success(data: T) = Resource(data, null, null)
        fun error(error: String) = Resource(null, error, null)
        fun exception(exception: Exception) = Resource(null, null, exception)
    }
}
