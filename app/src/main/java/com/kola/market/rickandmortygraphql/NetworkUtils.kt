package com.kola.market.rickandmortygraphql

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.exception.ApolloException
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.DataSourceException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun <D : Query.Data, R> executeApolloQuery(query: ApolloCall<D>, mapFunction: (D) -> R): Flow<RichAndMortyResult<R>> {
    return flow{
    try {
        val response = query.execute()
        if (response.hasErrors()) {
                emit( RichAndMortyResult.Error(DataSourceException.Server(Error(response.errors?.first()?.message))))
        } else {
                response.data?.let { mapFunction(it) }?.let {
                emit(RichAndMortyResult.Success(it))
            }
        }
    } catch (e: ApolloException) {
        emit(RichAndMortyResult.Error(DataSourceException.Server(Error(e.localizedMessage))))
    }
}
}

