package com.example.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.remote.model.Article
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.listners.OnItemClickListener
import com.example.newsapp.viewmodel.NewsViewModel

class NewsAdapter(
    private val context: Context,
    private val newsList: List<Article>,
    private val viewModel: NewsViewModel,
    private val onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(
        val binding: NewsItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding= NewsItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.binding.newsEditor.text = newsList.get(position).source.name
        holder.binding.newsTitle.text = newsList.get(position).title
        holder.binding.newsDescription.text = newsList.get(position).description
        holder.binding.newsPublish.text = getDate(position)
        holder.itemView.setOnClickListener {
            viewModel.currentNews = newsList.get(position).url
            onItemClickListener.onItemClick(position)
        }
        Glide.with(context).load(newsList.get(position).urlToImage).into(holder.binding.newsImage)

    }

    private fun getDate(position: Int): String{
        val year = newsList.get(position).publishedAt.substring(0,4)
        val month = newsList.get(position).publishedAt.substring(5,7)
        val day = newsList.get(position).publishedAt.substring(8,10)
        return "Date: $day-$month-$year"
    }

}