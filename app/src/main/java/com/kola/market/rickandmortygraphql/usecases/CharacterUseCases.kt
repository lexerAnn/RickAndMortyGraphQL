package com.kola.market.rickandmortygraphql.usecases

import android.util.Log
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import com.kola.market.rickandmortygraphql.datasource.remote.RemoteRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

data class CharacterUseCases @Inject constructor(
    private val remoteRepository: RemoteRepository
) {
    suspend operator fun invoke(request: Int): Flow<RichAndMortyResult<CharactersModel?>> {
        remoteRepository.getCharacters(request).collect {
            Timber.tag("dataNew").d(it.toString())
        }

        return remoteRepository.getCharacters(request)
    }
}