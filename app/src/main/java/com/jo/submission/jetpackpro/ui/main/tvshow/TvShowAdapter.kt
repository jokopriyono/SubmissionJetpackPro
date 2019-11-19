package com.jo.submission.jetpackpro.ui.main.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.data.model.api.TvShow

class TvShowAdapter(
    private val tvShow: List<TvShow>,
    private val tvShowListener: TvShowListener
) : RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = tvShow.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val m = tvShow[position]
        holder.txtTitle.text = m.name
        holder.txtDesc.text = m.overview
        holder.txtDate.text = m.firstAirDate
        holder.itemView.setOnClickListener { tvShowListener.onTvShowClick(m) }
        tvShowListener.onLoadImage(holder.imgPoster, m.posterPath)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        val txtDesc: TextView = itemView.findViewById(R.id.txt_description)
        val txtDate: TextView = itemView.findViewById(R.id.txt_date)
        val imgPoster: ImageView = itemView.findViewById(R.id.img_poster)
    }
}