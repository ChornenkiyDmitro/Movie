package com.example.movie.di.componenent

import com.example.movie.di.module.RemoteDataModule
import com.example.movie.di.scope.RemoteDataScope
import com.example.movie.remote_data_source.RemoteDataSource
import dagger.Component

@RemoteDataScope
@Component(modules = [RemoteDataModule::class], dependencies = [AppComponent::class])
interface RemoteDataComponent {
    val repositoryRemoteDataScope: RemoteDataSource
}