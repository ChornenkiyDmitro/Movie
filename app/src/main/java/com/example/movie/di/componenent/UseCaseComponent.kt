package com.example.movie.di.componenent

import com.example.movie.di.module.UseCaseModule
import com.example.movie.di.scope.UseCaseScope
import com.example.movie.use_case.ShowListFilmUseCase
import dagger.Component

@UseCaseScope
@Component(modules = [UseCaseModule::class], dependencies = [RepositoryComponent::class])
interface UseCaseComponent{
    val showListFilmUseCase: ShowListFilmUseCase
}