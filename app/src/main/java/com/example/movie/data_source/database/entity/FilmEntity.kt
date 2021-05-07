package com.example.movie.data_source.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "film")
data class FilmEntity(

    @PrimaryKey val id: Int?,

    @SerializedName("original_title")
    val title: String?,

    @SerializedName("vote_average")
    val voteAverage: String?,

    @SerializedName("poster_path")
    val poster: String?

)