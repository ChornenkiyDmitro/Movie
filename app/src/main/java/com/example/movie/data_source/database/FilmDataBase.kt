package com.example.movie.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movie.data_source.database.dao.FilmDao
import com.example.movie.data_source.database.entity.FilmEntity

@Database(entities = [FilmEntity::class], version = 1)
abstract class FilmDataBase : RoomDatabase() {
    abstract fun repositoryDao(): FilmDao
}