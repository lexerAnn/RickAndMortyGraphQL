package com.kola.market.rickandmortygraphql.datasource.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity(tableName = "episode", primaryKeys = ["id"])
@Parcelize
data class EpisodeModel(
    val id: String,
    val name: String
) : Parcelable