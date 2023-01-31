package com.kola.market.rickandmortygraphql.di

import com.kola.market.rickandmortygraphql.RickMortyApi
import com.kola.market.rickandmortygraphql.datasource.remote.RemoteRepository
import com.kola.market.rickandmortygraphql.datasource.remote.RemoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun providesRemoteRepository(webService: RickMortyApi): RemoteRepository {
        return RemoteRepositoryImpl(webService)
    }
}
