package com.example.movie.di.componenent

import com.example.movie.data_source.DataSource
import com.example.movie.di.module.DataModule
import dagger.Component

@Component(modules = [DataModule::class])
interface DataComponent {
    val dataSource: DataSource
}