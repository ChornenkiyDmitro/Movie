package com.example.movie.di.module

import com.example.movie.data_source.DataSource
import com.example.movie.di.scope.RepositoryScope
import com.example.movie.remote_data_source.RemoteDataSource
import com.example.movie.repository.FilmRepository
import com.example.movie.repository.FilmRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @RepositoryScope
    @Provides
    internal fun providesFeedRepository(remoteDataSource: RemoteDataSource, dataSource: DataSource): FilmRepository {
        return FilmRepositoryImpl(dataSource, remoteDataSource)
    }
}