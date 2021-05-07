package com.example.movie.presentation.main.film_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.MovieApp
import com.example.movie.R
import com.example.movie.data_source.database.entity.FilmEntity
import com.example.movie.presentation.main.film_list.adapter.FilmsListAdapter
import com.example.movie.view_model.FilmListViewModel
import kotlinx.android.synthetic.main.fragment_film_list.*
import javax.inject.Inject

class FilmListFragment : Fragment(){

    var filmListViewModel: FilmListViewModel? = null @Inject set
    val adapter = FilmsListAdapter()

    companion object {
        fun newInstance() = FilmListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_film_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as MovieApp).getViewModelComponent().inject(this)

        recyclerListFilms.adapter = adapter
        recyclerListFilms.layoutManager = LinearLayoutManager(context)

        filmListViewModel?.fetchListFilms()

        filmListViewModel?.listFilms?.observe(viewLifecycleOwner, Observer<List<FilmEntity>> {
            adapter.setData(it)
        })
    }
}