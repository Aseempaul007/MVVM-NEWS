package com.example.newsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.ui.fragment.BusinessFragment
import com.example.newsapp.ui.fragment.EntertainmentFragment
import com.example.newsapp.ui.fragment.HealthFragment
import com.example.newsapp.ui.fragment.ScienceFragment
import com.example.newsapp.ui.fragment.SportsFragment
import com.example.newsapp.ui.fragment.TechnologyFragment
import com.example.newsapp.ui.fragment.TopHeadlineFragment
import com.example.newsapp.util.Constants
import com.example.newsapp.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewsBinding
    lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        Constants.goToFragment(supportFragmentManager,TopHeadlineFragment())

        binding.entertainment.setOnClickListener {
            Constants.goToFragment(supportFragmentManager,EntertainmentFragment())
        }

        binding.science.setOnClickListener {
            Constants.goToFragment(supportFragmentManager,ScienceFragment())
        }

        binding.sports.setOnClickListener {
            Constants.goToFragment(supportFragmentManager,SportsFragment())
        }

        binding.technology.setOnClickListener {
            Constants.goToFragment(supportFragmentManager,TechnologyFragment())
        }

        binding.business.setOnClickListener {
            Constants.goToFragment(supportFragmentManager,BusinessFragment())
        }

        binding.health.setOnClickListener {
            Constants.goToFragment(supportFragmentManager,HealthFragment())
        }
    }
}