package com.jo.submission.jetpackpro.ui.main.tvshow

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TvShowFragmentProvider {

    @ContributesAndroidInjector(modules = [TvShowFragmentModule::class])
    abstract fun provideTvShowFragmentFactory(): TvShowFragment
}