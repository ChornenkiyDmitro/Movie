package com.example.movie.remote_data_source

import com.example.movie.data_source.database.entity.FilmEntity
import com.example.movie.remote_data_source.pojo.MoviesResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    companion object {
        const val API_KEY = "3a85880839bd62582a40fb4bca84e26e"
    }
    @GET("movie/popular")
    fun showPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): Single<MoviesResponse>
}