package com.example.movie.di.module

import com.example.movie.data_source.DataSource
import com.example.movie.data_source.DataSourceImpl
import com.example.movie.data_source.database.FilmDataBase
import dagger.Module
import dagger.Provides

@Module
class DataModule(private val filmDataBase: FilmDataBase){

    @Provides
    internal fun providesAppDatabase(): FilmDataBase {
        return filmDataBase
    }

    @Provides
    internal fun providesFeedDataSource(filmDataBase: FilmDataBase): DataSource {
        return DataSourceImpl(filmDataBase)
    }
}