package com.example.models.response

enum class Status {
    SUCCESS, ERROR, LOADING
}

data class Resource<T>(val status: Status, val data: T?, val errorMessage: String?) {
    companion object {

        fun <T> success(data: T): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> error(data: T?, errorMessage: String?): Resource<T> =
            Resource(Status.ERROR, data, errorMessage)

        fun <T> loading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
    }

}
