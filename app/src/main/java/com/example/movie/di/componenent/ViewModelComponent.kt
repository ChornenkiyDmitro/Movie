package com.example.movie.di.componenent

import com.example.movie.di.module.ViewModelModule
import com.example.movie.di.scope.ViewModelScope
import com.example.movie.presentation.main.MainActivity
import com.example.movie.presentation.main.film_list.FilmListFragment
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [UseCaseComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: FilmListFragment)

}