package com.jo.submission.jetpackpro.ui.main.movies

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jo.submission.jetpackpro.BR
import com.jo.submission.jetpackpro.BuildConfig
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.data.model.api.Movie
import com.jo.submission.jetpackpro.databinding.FragmentMoviesBinding
import com.jo.submission.jetpackpro.ui.base.BaseFragment
import com.jo.submission.jetpackpro.ui.detail.DetailActivity
import com.jo.submission.jetpackpro.ui.main.MainNavigator
import com.jo.submission.jetpackpro.ui.main.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movies.*
import org.jetbrains.anko.support.v4.startActivity
import javax.inject.Inject

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MainViewModel>(), MainNavigator,
    MovieListener {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun getLayoutId() = R.layout.fragment_movies

    override fun getBindingVariable() = BR.viewModel

    override fun getViewModel() =
        ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)

    companion object {
        @JvmStatic
        fun newInstance(): MoviesFragment {
            val moviesFragment = MoviesFragment()
            val args = Bundle()
            moviesFragment.arguments = args
            return moviesFragment
        }
    }

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var mFragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setNavigator(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            recycler_movie.layoutManager = LinearLayoutManager(it)
            getViewModel().movies.observe(this, Observer { response ->
                response?.let { data ->

                    movieAdapter = MovieAdapter(data.movies, this)

                    recycler_movie.setHasFixedSize(true)
                    recycler_movie.adapter = movieAdapter
                }
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentMoviesBinding = getViewDataBinding()
    }

    override fun onMovieClick(movie: Movie) {
        startActivity<DetailActivity>(DetailActivity.INTENT_DATA to movie)
    }

    override fun onLoadImage(target: ImageView, posterPath: String) {
        Picasso.get().load(BuildConfig.IMAGE_URL + posterPath.substring(1))
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_movies_black)
            .into(target)
    }

    override fun handleError(throwable: Throwable?) {

    }
}