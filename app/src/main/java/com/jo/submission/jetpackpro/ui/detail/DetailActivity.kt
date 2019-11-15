package com.jo.submission.jetpackpro.ui.detail


import android.os.Bundle
import com.jo.submission.jetpackpro.BR
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.databinding.ActivityDetailBinding
import com.jo.submission.jetpackpro.model.Movie
import com.jo.submission.jetpackpro.model.TvShow
import com.jo.submission.jetpackpro.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>(), DetailNavigator {

    @Inject
    lateinit var mDetailViewModel: DetailViewModel

    override fun getLayoutId() = R.layout.activity_detail

    override fun getBindingVariable() = BR.viewModel

    override fun getViewModel() = mDetailViewModel

    companion object {
        const val INTENT_DATA_2 = "data_tv_show"
        const val INTENT_DATA = "data_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDetailViewModel.setNavigator(this)

        intent.extras?.let {
            val data = it.getParcelable(INTENT_DATA) as Movie?
            data?.let { d ->
                mDetailViewModel.movie = d
            }

            val data2 = it.getParcelable(INTENT_DATA_2) as TvShow?
            data2?.let { tv ->
                mDetailViewModel.tvShow = tv
            }
        }
    }

    override fun showTitleAndImages(title: String, urlPoster: String, urlBackdrop: String) {
        this.title = title

        Picasso.get()
            .load(urlPoster)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_movies_black)
            .into(img_poster)
        Picasso.get()
            .load(urlBackdrop)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_movies_black)
            .into(img_backdrop)
    }
}
