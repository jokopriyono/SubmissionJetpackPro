package com.jo.submission.jetpackpro.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.model.Movie
import com.jo.submission.jetpackpro.model.TvShow
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val INTENT_DATA_2 = "data_tv_show"
        const val INTENT_DATA = "data_movie"
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        intent.extras?.let {
            val data = it.getParcelable(INTENT_DATA) as Movie?
            data?.let { d ->
                viewModel.movie = d

                title = viewModel.movie.originalTitle
                txt_title.text = viewModel.movie.title
                txt_date.text = viewModel.movie.releaseDate
                txt_overview.text = viewModel.movie.overview

                Picasso.get().load("https://image.tmdb.org/t/p/w500${viewModel.movie.posterPath}")
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_movies_black)
                    .into(img_poster)
                Picasso.get().load("https://image.tmdb.org/t/p/w500${viewModel.movie.backdropPath}")
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_movies_black)
                    .into(img_backdrop)
            }

            val data2 = it.getParcelable(INTENT_DATA_2) as TvShow?
            data2?.let { tv ->
                viewModel.tvShow = tv

                title = viewModel.tvShow.name
                txt_title.text = viewModel.tvShow.name
                txt_date.text = viewModel.tvShow.firstAirDate
                txt_overview.text = viewModel.tvShow.overview

                Picasso.get().load("https://image.tmdb.org/t/p/w500${viewModel.tvShow.posterPath}")
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_movies_black)
                    .into(img_poster)
                Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500${viewModel.tvShow.backdropPath}")
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_movies_black)
                    .into(img_backdrop)
            }
        }
    }
}
