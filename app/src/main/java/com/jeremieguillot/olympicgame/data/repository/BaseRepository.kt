package com.jeremieguillot.olympicgame.data.repository

import com.jeremieguillot.olympicgame.data.network.util.NetworkHandler
import com.jeremieguillot.olympicgame.domain.interactors.common.Failure
import kotlinx.coroutines.InternalCoroutinesApi
import retrofit2.Response
import javax.inject.Inject

open class BaseRepository @Inject constructor(
    private val networkHandler: NetworkHandler,
){

    @InternalCoroutinesApi
    suspend fun <T, R> request(
        call: suspend () -> Response<T>,
        transform: ((T) -> R)
    ): R {
        when (networkHandler.isNetworkAvailable()) {
            true -> {
                val response = call()
                return try {
                    when (response.code()) {
                        204 -> transform(Unit as T)
                        in 200..300 -> transform(response.body() ?: throw Failure.InvalidObject)
                        in 401..403 -> throw Failure.UnauthorizedError(response.message())
                        503 -> throw Failure.ServerUnderMaintenance(response.message())
                        else -> throw Failure.ServerError(response.message())
                    }
                } catch (exception: Throwable) {
                    throw exception
                }
            }
            false -> throw Failure.NetworkConnection
        }
    }
}