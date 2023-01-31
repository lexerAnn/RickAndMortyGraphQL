package com.kola.market.rickandmortygraphql.repository

import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getCharacters(page: Int): Flow<RichAndMortyResult<CharactersModel>>
}