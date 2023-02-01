package com.hb.rickandmortyapollo.data.mappers

import com.kola.market.rickandmortygraphql.GetCharacterDetailsQuery
import com.kola.market.rickandmortygraphql.GetCharactersQuery
import com.kola.market.rickandmortygraphql.datasource.models.*


fun GetCharactersQuery.Info.mapToDomainModel() = InfoModel(pages ?: 0, count ?: 0, next ?: 0)

fun GetCharactersQuery.Episode.mapToDomainModel() = EpisodeModel(id ?: "", name ?: "")

fun GetCharactersQuery.Result.mapToDomainModel() = SingleCharacterModel(
    id ?: "",
    name ?: "",
    image ?: "",
    episode.map { it!!.mapToDomainModel() }
)

fun GetCharacterDetailsQuery.Location.mapToDomainModel() = LocationModel(dimension?: "", name?:"")

fun GetCharactersQuery.Characters.mapToDomainModel() = CharactersModel(
    info?.mapToDomainModel() ?: InfoModel(),
    results?.map { it!!.mapToDomainModel() } ?: emptyList()
)
fun GetCharacterDetailsQuery.Character.mapToDomainModel() = CharacterDetailsModel(
    id?: "",
    name?: "",
    status?: "",
    species?: "",
    gender?: "",
    location?.mapToDomainModel()?: LocationModel(),
    location?.mapToDomainModel()?: LocationModel()
)