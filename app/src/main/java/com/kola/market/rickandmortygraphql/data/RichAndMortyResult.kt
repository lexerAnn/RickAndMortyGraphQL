package com.kola.market.rickandmortygraphql.data

import com.kola.market.rickandmortygraphql.datasource.models.DataSourceException

sealed class RichAndMortyResult<out T> {
    data class Success<out T>(val data: T): RichAndMortyResult<T>()
    data class Error(val exception: DataSourceException): RichAndMortyResult<Nothing>()
    object Loading: RichAndMortyResult<Nothing>()
}

inline fun <T : Any> RichAndMortyResult<T>.onSuccess(action: (T) -> Unit): RichAndMortyResult<T> {
    if (this is RichAndMortyResult.Success) action(data)
    return this
}

inline fun <T : Any> RichAndMortyResult<T>.onError(action: (DataSourceException) -> Unit): RichAndMortyResult<T> {
    if (this is RichAndMortyResult.Error) action(exception)
    return this
}

inline fun <T : Any> RichAndMortyResult<T>.onLoading(action: () -> Unit): RichAndMortyResult<T> {
    if (this is RichAndMortyResult.Loading) action()
    return this
}