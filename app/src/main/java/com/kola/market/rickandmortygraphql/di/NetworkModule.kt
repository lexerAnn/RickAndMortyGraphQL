package com.kola.market.rickandmortygraphql.di

import com.kola.market.rickandmortygraphql.RickMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

//    @Singleton
//    @Provides
//    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
//        return ApolloClient.Builder()
//            .serverUrl("https://rickandmortyapi.com/graphql")
//            .okHttpClient(okHttpClient)
//            .build()
//    }
//
//    @Provides
//    fun provideOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder().build()
//    }


    @Singleton
    @Provides
    fun provideWebService() = RickMortyApi()
}


