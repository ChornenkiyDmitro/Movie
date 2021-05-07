package com.example.movie.di.module

import com.example.movie.di.scope.UseCaseScope
import com.example.movie.repository.FilmRepository
import com.example.movie.use_case.ShowListFilmUseCase
import com.example.movie.use_case.ShowListFilmUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @UseCaseScope
    @Provides
    internal fun providesRepositoriesUseCases(repository: FilmRepository): ShowListFilmUseCase {
        return ShowListFilmUseCaseImpl(repository)
    }
}