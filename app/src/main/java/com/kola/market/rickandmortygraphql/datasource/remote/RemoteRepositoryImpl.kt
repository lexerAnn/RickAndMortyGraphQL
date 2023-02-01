package com.kola.market.rickandmortygraphql.datasource.remote

import com.hb.rickandmortyapollo.data.mappers.mapToDomainModel
import com.kola.market.rickandmortygraphql.GetCharacterDetailsQuery
import com.kola.market.rickandmortygraphql.GetCharactersQuery
import com.kola.market.rickandmortygraphql.RickMortyApi
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharacterDetailsModel
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import com.kola.market.rickandmortygraphql.executeApolloQuery
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val webService: RickMortyApi):
    RemoteRepository {

       override suspend fun getCharacters(page: Int): Flow<RichAndMortyResult<CharactersModel?>> {
        val query =  webService.getApolloClient().query(GetCharactersQuery())
        return executeApolloQuery(query){
            it.characters?.mapToDomainModel()
        }
    }

    override suspend fun getCharacterDetails(id: String): Flow<RichAndMortyResult<CharacterDetailsModel?>> {
        val query = webService.getApolloClient().query(GetCharacterDetailsQuery(id))
        return executeApolloQuery(query) {
            it.character?.mapToDomainModel()
        }
    }

}