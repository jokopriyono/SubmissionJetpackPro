package com.jo.submission.jetpackpro.ui.main.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.model.TvShow
import com.jo.submission.jetpackpro.ui.detail.DetailActivity
import com.jo.submission.jetpackpro.ui.main.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_tv_show.*
import org.jetbrains.anko.support.v4.startActivity

class TvShowFragment : Fragment(), TvShowListener {
    private lateinit var viewModel: MainViewModel

    private lateinit var tvShowAdapter: TvShowAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
            tvShowAdapter = TvShowAdapter(viewModel.tvShow, this)

            recycler_tv_show.layoutManager = LinearLayoutManager(it)
            recycler_tv_show.setHasFixedSize(true)
            recycler_tv_show.adapter = tvShowAdapter
        }
    }

    override fun onTvShowClick(tvShow: TvShow) {
        startActivity<DetailActivity>(DetailActivity.INTENT_DATA_2 to tvShow)
    }

    override fun onLoadImage(target: ImageView, posterPath: String?) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500$posterPath")
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_movies_black)
            .into(target)
    }
}