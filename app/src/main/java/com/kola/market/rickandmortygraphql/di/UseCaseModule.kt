package com.kola.market.rickandmortygraphql.di

import com.kola.market.rickandmortygraphql.datasource.remote.RemoteRepository
import com.kola.market.rickandmortygraphql.usecases.CharacterDetailsUseCases
import com.kola.market.rickandmortygraphql.usecases.CharacterUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @ViewModelScoped
    @Provides
    fun providesUseCases(
        remoteRepository: RemoteRepository
    ): UseCases {
        return UseCases(
            characterUseCases = CharacterUseCases(remoteRepository),
            characterDetailsUseCases = CharacterDetailsUseCases(remoteRepository)
        )
    }

}