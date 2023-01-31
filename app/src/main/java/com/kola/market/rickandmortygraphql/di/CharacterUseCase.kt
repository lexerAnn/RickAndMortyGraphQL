package com.kola.market.rickandmortygraphql.di

import com.kola.market.rickandmortygraphql.datasource.remote.RemoteRepository
import com.kola.market.rickandmortygraphql.usecases.CharacterUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ViewModelComponent::class)
class CharacterUseCase {
    @ViewModelScoped
    @Provides
    fun providesProfileUseCases(
        remoteRepository: RemoteRepository
    ): CharacterUseCases {
        return CharacterUseCases(remoteRepository)
    }

}