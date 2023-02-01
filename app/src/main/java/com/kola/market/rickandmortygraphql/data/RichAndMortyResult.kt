package com.kola.market.rickandmortygraphql.data

sealed class RichAndMortyResult<out T> {
    data class Success<out T>(val data: T): RichAndMortyResult<T>()
    data class Error(val exception: Exception): RichAndMortyResult<Nothing>()
    object Loading: RichAndMortyResult<Nothing>()
}