package com.example.movie.repository

import com.example.movie.data_source.DataSource
import com.example.movie.data_source.database.entity.FilmEntity
import com.example.movie.remote_data_source.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.Single

interface FilmRepository {

    fun fetchPopularMovies(): Completable
    fun deleteFilm(): Completable
    fun showPopularFilm(): Single<List<FilmEntity>>
}

class FilmRepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource
): FilmRepository{

    override fun fetchPopularMovies(): Completable {
       return remoteDataSource.fetchPopularMovies()
           .flatMapCompletable { list
               -> saveItems(items = list) }
    }

    override fun deleteFilm(): Completable {
       return dataSource.deleteFilm()
    }

    override fun showPopularFilm(): Single<List<FilmEntity>> {
        return dataSource.showPopularFilm()
    }

    private fun saveItems(
        items: List<FilmEntity>
    ): Completable {
            return dataSource.insertListFilms(items)
    }
}