package com.jeremieguillot.olympicgame.presentation.data

//Result class to manage repositories' calls and update state
sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Failure(
        val message: String? = null,
        val throwable: Throwable? = null,
    ) : Result<Nothing>()

    data class Success<out R>(val value: R) : Result<R>()
}