package com.kola.market.rickandmortygraphql.datasource.remote

import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharacterDetailsModel
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getCharacters(page: Int): Flow<RichAndMortyResult<CharactersModel?>>

    suspend fun getCharacterDetails(id: String): Flow<RichAndMortyResult<CharacterDetailsModel?>>
}