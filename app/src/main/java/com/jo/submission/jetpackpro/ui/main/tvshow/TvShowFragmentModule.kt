package com.jo.submission.jetpackpro.ui.main.tvshow

import com.jo.submission.jetpackpro.ViewModelProviderFactory
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.ui.main.MainViewModel
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class TvShowFragmentModule {

    @Provides
    fun mainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) =
        MainViewModel(dataManager, schedulerProvider)

    @Provides
    fun provideMainViewModel(mainViewModel: MainViewModel) =
        ViewModelProviderFactory(mainViewModel)
}