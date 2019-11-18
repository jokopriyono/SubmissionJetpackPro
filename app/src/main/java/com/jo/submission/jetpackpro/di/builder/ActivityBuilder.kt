package com.jo.submission.jetpackpro.di.builder

import com.jo.submission.jetpackpro.ui.detail.DetailActivity
import com.jo.submission.jetpackpro.ui.detail.DetailActivityModule
import com.jo.submission.jetpackpro.ui.main.MainActivity
import com.jo.submission.jetpackpro.ui.main.MainActivityModule
import com.jo.submission.jetpackpro.ui.main.movies.MoviesFragmentProvider
import com.jo.submission.jetpackpro.ui.main.tvshow.TvShowFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            MoviesFragmentProvider::class,
            TvShowFragmentProvider::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity

}