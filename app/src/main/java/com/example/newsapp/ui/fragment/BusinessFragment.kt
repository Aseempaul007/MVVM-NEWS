package com.example.newsapp.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.FragmentBusinessBinding
import com.example.newsapp.listners.OnItemClickListener
import com.example.newsapp.ui.activity.NewsWebActivity
import com.example.newsapp.util.Constants
import com.example.newsapp.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class BusinessFragment : Fragment(), OnItemClickListener {

    var binding: FragmentBusinessBinding? = null
    var viewModel: NewsViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusinessBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        binding!!.progressBar.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.IO).launch {
            val news = viewModel?.getBusinessNews(
                Constants.NEWS_COUNTRY,
                Constants.apiKey,
                "business"
            )?.body()
            withContext(Dispatchers.Main){
                binding!!.progressBar.visibility = View.INVISIBLE
                binding?.newsRecycler?.adapter = NewsAdapter(
                    requireContext(),
                    news!!.articles,
                    viewModel!!,
                    this@BusinessFragment
                    )
                binding?.newsRecycler?.layoutManager = LinearLayoutManager(requireContext())
            }
        }
        return binding?.root
    }

    override fun onItemClick(position: Int) {
        val i = Intent(requireContext(),NewsWebActivity::class.java)
        i.putExtra("news_url",viewModel?.currentNews)
        activity?.overridePendingTransition(
            R.anim.slide_out_left,
            R.anim.slide_in_right)
        startActivity(i)
    }
}