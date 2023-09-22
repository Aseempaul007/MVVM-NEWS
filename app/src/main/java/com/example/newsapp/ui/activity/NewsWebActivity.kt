package com.example.newsapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.ActivityNewsWebBinding
import com.example.newsapp.util.Constants
import com.example.newsapp.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsWebActivity : AppCompatActivity() {

    var binding: ActivityNewsWebBinding?=null
    var viewModel: NewsViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsWebBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        val url = intent.getStringExtra("news_url")
        if(Constants.isNetworkAvailable(this)){
            Log.d(Constants.MYTAG,url.toString())
            val webSettings = binding?.webView?.settings
            webSettings?.javaScriptEnabled
            binding!!.progressBar.setVisibility(View.VISIBLE)
            binding?.webView?.loadUrl(url.toString())
            binding?.webView?.webViewClient = WebViewClient()
            webSettings?.setLoadWithOverviewMode(true);
            webSettings?.setUseWideViewPort(true);
            webSettings?.setJavaScriptEnabled(true);
            webSettings?.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings?.setDatabaseEnabled(false);
            webSettings?.setDomStorageEnabled(false);
            webSettings?.setGeolocationEnabled(false);
            webSettings?.setSaveFormData(false);
            binding!!.progressBar.visibility = View.INVISIBLE
        }else{
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
        }

    }
}