package com.example.movie.data_source.database.dao

import androidx.room.*
import com.example.movie.data_source.database.entity.FilmEntity
import io.reactivex.Single

@Dao
interface FilmDao {

    @Query("DELETE FROM film")
    fun deleteFilm()

    @Query("SELECT * FROM film")
    fun showPopularFilm(): Single<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListFilms(filmList: List<FilmEntity>)

}