package com.hb.rickandmortyapollo.data.mappers

import com.kola.market.rickandmortygraphql.GetCharactersQuery
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import com.kola.market.rickandmortygraphql.datasource.models.EpisodeModel
import com.kola.market.rickandmortygraphql.datasource.models.InfoModel
import com.kola.market.rickandmortygraphql.datasource.models.SingleCharacterModel


fun GetCharactersQuery.Info.mapToDomainModel() = InfoModel(pages ?: 0, count ?: 0, next ?: 0)

fun GetCharactersQuery.Episode.mapToDomainModel() = EpisodeModel(id ?: "", name ?: "")

fun GetCharactersQuery.Result.mapToDomainModel() = SingleCharacterModel(
    id ?: "",
    name ?: "",
    image ?: "",
    episode?.map { it!!.mapToDomainModel() } ?: emptyList()
)

fun GetCharactersQuery.Characters.mapToDomainModel() = CharactersModel(
    info?.mapToDomainModel() ?: InfoModel(),
    results?.map { it!!.mapToDomainModel() } ?: emptyList()
)