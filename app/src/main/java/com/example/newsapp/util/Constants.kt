package com.example.newsapp.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.newsapp.R

object Constants {
    val MYTAG = "MYTAG"
    val NEWS_URL = "https://newsapi.org/v2/"
    val NEWS_COUNTRY = "in"
    val apiKey = "d09c1fd9b8194977a1a8534e70e73334"
    fun goToFragment(fm: FragmentManager,fragment: Fragment){
        val ft = fm.beginTransaction()
        ft.replace(R.id.newsFrame,fragment)
        ft.commit()
    }
}