package com.example.movie.remote_data_source

import com.example.movie.data_source.database.entity.FilmEntity
import io.reactivex.Single

interface RemoteDataSource {

    fun fetchPopularMovies(): Single<List<FilmEntity>>
}

class RemoteDataSourceImpl(private val movieApi: MovieApi): RemoteDataSource{
    override fun fetchPopularMovies(): Single<List<FilmEntity>> {
        return movieApi.showPopularMovies().map {
            it.result
        }
    }
}