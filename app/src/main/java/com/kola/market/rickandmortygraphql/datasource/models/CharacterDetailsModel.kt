package com.kola.market.rickandmortygraphql.datasource.models

data class CharacterDetailsModel(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: LocationModel,
    val locationModel: LocationModel
)