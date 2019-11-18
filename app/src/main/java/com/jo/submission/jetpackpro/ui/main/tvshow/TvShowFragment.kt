package com.jo.submission.jetpackpro.ui.main.tvshow

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jo.submission.jetpackpro.BR
import com.jo.submission.jetpackpro.R
import com.jo.submission.jetpackpro.databinding.FragmentTvShowBinding
import com.jo.submission.jetpackpro.model.TvShow
import com.jo.submission.jetpackpro.ui.base.BaseFragment
import com.jo.submission.jetpackpro.ui.detail.DetailActivity
import com.jo.submission.jetpackpro.ui.main.MainNavigator
import com.jo.submission.jetpackpro.ui.main.MainViewModel
import com.squareup.picasso.Picasso
import org.jetbrains.anko.support.v4.startActivity
import javax.inject.Inject

class TvShowFragment : BaseFragment<FragmentTvShowBinding, MainViewModel>(), TvShowListener,
    MainNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun getLayoutId() = R.layout.fragment_tv_show

    override fun getBindingVariable() = BR.viewModel

    override fun getViewModel(): MainViewModel =
        ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)

    companion object {
        @JvmStatic
        fun newInstance(): TvShowFragment {
            val tvShowFragment = TvShowFragment()
            val args = Bundle()
            tvShowFragment.arguments = args
            return tvShowFragment
        }
    }

    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var mFragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setNavigator(this)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
            tvShowAdapter = TvShowAdapter(viewModel.tvShow, this)

            recycler_tv_show.layoutManager = LinearLayoutManager(it)
            recycler_tv_show.setHasFixedSize(true)
            recycler_tv_show.adapter = tvShowAdapter
        }
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentTvShowBinding = getViewDataBinding()
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

    override fun handleError(throwable: Throwable?) {

    }
}