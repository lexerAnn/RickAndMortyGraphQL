package com.kola.market.rickandmortygraphql.datasource.remote

import com.hb.rickandmortyapollo.data.mappers.mapToDomainModel
import com.kola.market.rickandmortygraphql.GetCharactersQuery
import com.kola.market.rickandmortygraphql.RickMortyApi
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import com.kola.market.rickandmortygraphql.executeApolloQuery
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val webService: RickMortyApi): RemoteRepository{

       override suspend fun getCharacters(page: Int): Flow<RichAndMortyResult<CharactersModel?>> {
        val query =  webService.getApolloClient().query(GetCharactersQuery())
        return executeApolloQuery(query){
            it?.characters?.mapToDomainModel()
        }
    }

}