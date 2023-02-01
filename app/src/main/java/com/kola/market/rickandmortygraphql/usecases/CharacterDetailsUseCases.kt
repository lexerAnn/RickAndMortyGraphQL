package com.kola.market.rickandmortygraphql.usecases

import android.util.Log
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharacterDetailsModel
import com.kola.market.rickandmortygraphql.datasource.remote.RemoteRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

data class CharacterDetailsUseCases @Inject constructor(
    private val remoteRepository: RemoteRepository
) {
    suspend operator fun invoke(id: String): Flow<RichAndMortyResult<CharacterDetailsModel?>> {
        remoteRepository.getCharacterDetails(id).collect {
            Timber.tag("dataNew").d(it.toString())
        }
        return remoteRepository.getCharacterDetails(id)
    }
}