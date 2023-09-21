package com.example.newsapp.data.remote.api

import com.example.newsapp.data.remote.model.NewsArticle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
interface NewsApi {

    @GET("top-headlines")
    suspend fun getLatestNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        apiKey: String
    ): Response<NewsArticle>

    @GET("top-headlines")
    suspend fun getEntertainmentNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        apiKey: String,
        @Query("category")
        category: String
    ): Response<NewsArticle>

    @GET("top-headlines")
    suspend fun getScienceNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        apiKey: String,
        @Query("category")
        category: String
    ): Response<NewsArticle>

    @GET("top-headlines")
    suspend fun getSportsNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        apikey: String,
        @Query("category")
        category: String
    ): Response<NewsArticle>

    @GET("top-headlines")
    suspend fun getTechnologyNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        apikey: String,
        @Query("category")
        category: String
    ): Response<NewsArticle>

    @GET("top-headlines")
    suspend fun getBusinessNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        apikey: String,
        @Query("category")
        category: String
    ): Response<NewsArticle>

    @GET("top-headlines")
    suspend fun getHealthNews(
        @Query("country")
        country: String,
        @Query("apiKey")
        apikey: String,
        @Query("category")
        category: String
    ): Response<NewsArticle>

}