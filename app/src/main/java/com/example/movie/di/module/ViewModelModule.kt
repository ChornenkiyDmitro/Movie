package com.example.movie.di.module

import android.app.Application
import com.example.movie.MovieApp
import com.example.movie.di.scope.ViewModelScope
import com.example.movie.use_case.ShowListFilmUseCase
import com.example.movie.view_model.FilmListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule (app: MovieApp){

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesFeedViewModel(showListFilmUseCase: ShowListFilmUseCase): FilmListViewModel {
        return FilmListViewModel(showListFilmUseCase)
    }
}