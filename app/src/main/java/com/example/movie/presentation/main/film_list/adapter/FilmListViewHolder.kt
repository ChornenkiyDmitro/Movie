package com.example.movie.presentation.main.film_list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.data_source.database.entity.FilmEntity
import kotlinx.android.synthetic.main.item_film_list.view.*

class FilmListViewHolder(
    itemView: View
): RecyclerView.ViewHolder(itemView) {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

    fun bind(films: FilmEntity){
        itemView.textFilmName.text = films.title
        itemView.textFilmGrade.text = films.voteAverage
        Glide.with(itemView)
            .load(IMAGE_BASE + films.poster)
            .into(itemView.imageFilmPoster)
    }
}