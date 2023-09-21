package com.example.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newsapp.data.remote.model.NewsArticle
import com.example.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository): ViewModel() {

    var currentNews = ""

    suspend fun getLatestNews(country: String, apiKey: String): Response<NewsArticle> {
        return newsRepository.getLatestNews(country, apiKey)
    }

    suspend fun getEntertainmentNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsRepository.getEntertainmentNews(country, apiKey,category)
    }

    suspend fun getScienceNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsRepository.getScienceNews(country, apiKey,category)
    }

    suspend fun getSportsNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsRepository.getSportsNews(country, apiKey, category)
    }

    suspend fun getTechnologyNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsRepository.getTechnologyNews(country, apiKey, category)
    }

    suspend fun getBusinessNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsRepository.getBusinessNews(country, apiKey, category)
    }

    suspend fun getHealthNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsRepository.getHealthNews(country, apiKey, category)
    }

}