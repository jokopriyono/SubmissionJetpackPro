package com.jo.submission.jetpackpro.ui.main.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.model.MoviesModel

class MovieAdapter(
    private val movies: MoviesModel,
    private val movieListener: MovieListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val m = movies.results[position]
        holder.txtTitle.text = m.originalTitle
        holder.txtDesc.text = m.overview
        holder.txtDate.text = m.releaseDate
        holder.itemView.setOnClickListener { movieListener.onMovieClick(m) }
        movieListener.onLoadImage(holder.imgPoster, m.posterPath)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        val txtDesc: TextView = itemView.findViewById(R.id.txt_description)
        val txtDate: TextView = itemView.findViewById(R.id.txt_date)
        val imgPoster: ImageView = itemView.findViewById(R.id.img_poster)
    }
}