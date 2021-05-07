package com.example.movie.di.componenent

import com.example.movie.di.module.RepositoryModule
import com.example.movie.di.scope.RepositoryScope
import com.example.movie.repository.FilmRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [RemoteDataComponent::class, DataComponent::class])
interface RepositoryComponent {
    val filmRepository: FilmRepository
}