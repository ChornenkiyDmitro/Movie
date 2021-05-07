package com.example.movie.presentation.main.film_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data_source.database.entity.FilmEntity

class FilmsListAdapter: RecyclerView.Adapter<FilmListViewHolder>(){

    private var filmList = mutableListOf<FilmEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {
        return FilmListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film_list, parent, false)
        )
    }

    override fun getItemCount(): Int = filmList.size

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        holder.bind(filmList.get(position))
    }

    fun setData(films : List<FilmEntity>) {
        filmList.clear()
        filmList.addAll(films)
        notifyDataSetChanged()
    }
}