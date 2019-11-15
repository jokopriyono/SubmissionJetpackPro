package com.jo.submission.jetpackpro.di.builder

import com.jo.submission.jetpackpro.ui.detail.DetailActivity
import com.jo.submission.jetpackpro.ui.detail.DetailActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity

}