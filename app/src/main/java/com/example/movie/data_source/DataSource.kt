package com.example.movie.data_source

import com.example.movie.data_source.database.FilmDataBase
import com.example.movie.data_source.database.entity.FilmEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataSource {

    fun deleteFilm(): Completable
    fun showPopularFilm(): Single<List<FilmEntity>>
    fun insertListFilms(filmList: List<FilmEntity>): Completable

}

class DataSourceImpl (private val filmDataBase: FilmDataBase) : DataSource {

    override fun deleteFilm(): Completable =
        Completable.fromAction {
            filmDataBase.repositoryDao().deleteFilm()
        }

    override fun showPopularFilm(): Single<List<FilmEntity>> =
        filmDataBase.repositoryDao().showPopularFilm()

    override fun insertListFilms(filmList: List<FilmEntity>): Completable =
        Completable.fromAction {
            filmDataBase.repositoryDao().insertListFilms(filmList)
        }
}