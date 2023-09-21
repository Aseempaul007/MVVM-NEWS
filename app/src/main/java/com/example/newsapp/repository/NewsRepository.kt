package com.example.newsapp.repository

import com.example.newsapp.data.remote.api.NewsApi
import com.example.newsapp.data.remote.model.NewsArticle
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(val newsApi: NewsApi) {

    suspend fun getLatestNews(country: String, apiKey: String): Response<NewsArticle>{
        return newsApi.getLatestNews(country, apiKey)
    }

    suspend fun getEntertainmentNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsApi.getEntertainmentNews(country, apiKey,category)
    }

    suspend fun getScienceNews(country: String, apiKey: String,category: String): Response<NewsArticle>{
        return newsApi.getScienceNews(country, apiKey,category)
    }

    suspend fun getSportsNews(country: String,apiKey: String,category: String): Response<NewsArticle>{
        return newsApi.getSportsNews(country,apiKey,category)
    }

    suspend fun getTechnologyNews(country: String,apiKey: String,category: String): Response<NewsArticle>{
        return newsApi.getTechnologyNews(country,apiKey,category)
    }

    suspend fun getBusinessNews(country: String,apiKey: String,category: String): Response<NewsArticle>{
        return newsApi.getBusinessNews(country,apiKey,category)
    }

    suspend fun getHealthNews(country: String,apiKey: String,category: String): Response<NewsArticle>{
        return newsApi.getHealthNews(country,apiKey,category)
    }

}