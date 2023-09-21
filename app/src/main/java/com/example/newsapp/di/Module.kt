package com.example.newsapp.di

import com.example.newsapp.data.remote.api.NewsApi
import com.example.newsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    @Singleton
    fun getRetrofitIns(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.NEWS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun getNewsApi(retrofit: Retrofit): NewsApi{
        return retrofit.create(NewsApi::class.java)
    }

}