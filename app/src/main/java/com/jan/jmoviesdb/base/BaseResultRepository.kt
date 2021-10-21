package com.jan.jmoviesdb.base

/**
 * This will be useful to get the data if the request was successful or get the exception if our request failed
 * @author Jaime Trujillo
 */
sealed class BaseResultRepository<out T : Any> {
    class Success<out T : Any>(val data: T?) : BaseResultRepository<T>()
    class Error(val exception: Throwable) : BaseResultRepository<Nothing>()
    class NetworkError(val exception: Throwable) : BaseResultRepository<Nothing>()
}