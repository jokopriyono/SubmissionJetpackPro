package com.jo.submission.jetpackpro.ui.main

import androidx.lifecycle.ViewModelProvider
import com.jo.submission.jetpackpro.ViewModelProviderFactory
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(mainViewModel)

    @Provides
    fun provideDetailViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): MainViewModel =
        MainViewModel(dataManager, schedulerProvider)

}