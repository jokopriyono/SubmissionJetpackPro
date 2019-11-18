package com.jo.submission.jetpackpro.ui.main.movies

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoviesFragmentProvider {

    @ContributesAndroidInjector(modules = [MoviesFragmentModule::class])
    abstract fun provideMoviesFragmentFactory(): MoviesFragment
}