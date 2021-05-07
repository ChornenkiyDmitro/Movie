package com.example.movie.remote_data_source.pojo

import com.example.movie.data_source.database.entity.FilmEntity
import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val result: List<FilmEntity>
)