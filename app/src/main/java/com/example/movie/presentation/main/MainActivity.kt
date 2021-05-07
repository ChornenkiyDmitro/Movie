package com.example.movie.presentation.main

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.R
import com.example.movie.presentation.main.adapter.MainViewPagerAdapter
import com.example.movie.presentation.main.film_list.FilmListFragment
import com.example.movie.presentation.main.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()


        val adapter =  MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FilmListFragment.newInstance(), "Movies")
        adapter.addFragment(ProfileFragment.newInstance(), "Profile")

        caseMainFragment.adapter = adapter
        tabsMain.setupWithViewPager(caseMainFragment)
    }
}