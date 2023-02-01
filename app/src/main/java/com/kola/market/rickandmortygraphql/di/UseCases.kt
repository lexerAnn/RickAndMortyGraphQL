package com.kola.market.rickandmortygraphql.di

import com.kola.market.rickandmortygraphql.usecases.CharacterDetailsUseCases
import com.kola.market.rickandmortygraphql.usecases.CharacterUseCases

data class UseCases(
    val characterUseCases: CharacterUseCases,
    val characterDetailsUseCases: CharacterDetailsUseCases
)