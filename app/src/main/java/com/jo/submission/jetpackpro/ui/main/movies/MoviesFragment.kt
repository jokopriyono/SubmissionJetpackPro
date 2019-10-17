package com.jo.submission.jetpackpro.ui.main.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.model.Movie
import com.jo.submission.jetpackpro.ui.detail.DetailActivity
import com.jo.submission.jetpackpro.ui.main.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movies.*
import org.jetbrains.anko.support.v4.startActivity

class MoviesFragment : Fragment(), MovieListener {
    companion object {
        @JvmStatic
        fun newInstance(): MoviesFragment {
            val moviesFragment = MoviesFragment()
            val args = Bundle()
            moviesFragment.arguments = args
            return moviesFragment
        }
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
            movieAdapter = MovieAdapter(viewModel.movies, this)

            recycler_movie.layoutManager = LinearLayoutManager(it)
            recycler_movie.setHasFixedSize(true)
            recycler_movie.adapter = movieAdapter
        }
    }

    override fun onMovieClick(movie: Movie) {
        startActivity<DetailActivity>(DetailActivity.INTENT_DATA to movie)
    }

    override fun onLoadImage(target: ImageView, posterPath: String) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500$posterPath")
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_movies_black)
            .into(target)
    }
}