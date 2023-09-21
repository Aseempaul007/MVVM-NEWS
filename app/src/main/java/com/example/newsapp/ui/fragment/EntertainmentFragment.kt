package com.example.newsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.FragmentEntertainmentBinding
import com.example.newsapp.util.Constants
import com.example.newsapp.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
@AndroidEntryPoint
class EntertainmentFragment : Fragment() {

    private var binding: FragmentEntertainmentBinding? = null
    private var viewModel: NewsViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentEntertainmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        binding?.progressBar?.setVisibility(View.VISIBLE)

        CoroutineScope(Dispatchers.IO).launch{
            val news = viewModel?.getEntertainmentNews(
                Constants.NEWS_COUNTRY,
                Constants.apiKey,
                "entertainment"
            )?.body()
            Log.d(Constants.MYTAG,news.toString())
            withContext(Dispatchers.Main){
                binding?.progressBar?.setVisibility(View.INVISIBLE)
                binding?.newsRecycler?.adapter = NewsAdapter(requireContext(),news!!.articles,
                    viewModel!!
                )
                binding?.newsRecycler?.layoutManager = LinearLayoutManager(requireContext())
            }

        }
        return binding?.root
    }
}