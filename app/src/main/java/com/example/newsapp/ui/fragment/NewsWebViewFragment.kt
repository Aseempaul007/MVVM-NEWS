package com.example.newsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.FragmentNewsWebViewBinding
import com.example.newsapp.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsWebViewFragment : Fragment() {

    var binding: FragmentNewsWebViewBinding? = null
    var viewModel: NewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentNewsWebViewBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        val mWebView = binding!!.newsWebView
        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true
        mWebView.loadUrl("https://www.google.com/")

        return binding!!.root
    }

}