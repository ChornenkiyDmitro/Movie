package com.example.movie.view_model

import androidx.lifecycle.MutableLiveData
import com.example.movie.data_source.database.entity.FilmEntity
import com.example.movie.use_case.ShowListFilmUseCase
import io.reactivex.rxkotlin.plusAssign

class FilmListViewModel(
    private val showListFilmUseCase: ShowListFilmUseCase
): BaseViewModel() {

    val listFilms = MutableLiveData<List<FilmEntity>>()

    private fun showListFilms() {
        compositeDisposable += showListFilmUseCase.showPopularFilm()
            .subscribe({
                list ->
                listFilms.value = list
            }, {
                it.printStackTrace()
            })
    }

    fun fetchListFilms(){
        compositeDisposable += showListFilmUseCase.fetchPopularMovies()
            .subscribe({
                showListFilms()
            }, {
                it.printStackTrace()
            })
    }
}