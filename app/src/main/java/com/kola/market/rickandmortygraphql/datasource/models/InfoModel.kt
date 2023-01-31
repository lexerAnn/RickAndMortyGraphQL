package com.kola.market.rickandmortygraphql.datasource.models

data class InfoModel(
    val pages: Int,
    val count: Int,
    val next: Int?
) {
    constructor() : this(0, 0, 0)
}