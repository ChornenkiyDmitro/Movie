package com.example.movie.use_case

import com.example.movie.data_source.database.entity.FilmEntity
import com.example.movie.repository.FilmRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface ShowListFilmUseCase {

    fun fetchPopularMovies(): Completable
    fun deleteFilm(): Completable
    fun showPopularFilm(): Single<List<FilmEntity>>
}

class ShowListFilmUseCaseImpl(
    private val repository: FilmRepository
): ShowListFilmUseCase {
    override fun fetchPopularMovies(): Completable =
        repository.fetchPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    override fun deleteFilm(): Completable =
        repository.deleteFilm()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    override fun showPopularFilm(): Single<List<FilmEntity>> =
        repository.showPopularFilm()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}