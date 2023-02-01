package com.kola.market.rickandmortygraphql

import com.apollographql.apollo3.ApolloClient
import com.kola.market.rickandmortygraphql.datasource.LoggingApolloInterceptor
import okhttp3.OkHttpClient

class RickMortyApi {
    fun getApolloClient(): ApolloClient {
//        check(Looper.myLooper() == Looper.getMainLooper()) {
//            "Only the main thread can get the apolloClient instance"
//        }

        val okHttpClient = OkHttpClient.Builder().build()

        return ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
//            .okHttpClient(okHttpClient)
            .addInterceptor(LoggingApolloInterceptor())
            .build()
    }
}