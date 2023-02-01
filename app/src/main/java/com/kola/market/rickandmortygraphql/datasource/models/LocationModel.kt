package com.kola.market.rickandmortygraphql.datasource.models

data class LocationModel(
    val name: String?,
    val dimension: String?
)   {
    constructor(): this("","")
}

